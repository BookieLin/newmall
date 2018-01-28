package com.vincent.newshop.module.sys.security;


import com.vincent.newshop.common.utils.StringUtils;
import com.vincent.newshop.module.admin.utils.AdminUtils;
import com.vincent.newshop.module.sys.dto.LoginDTO;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;


/**
 * 自定义表单验证过滤类（含验证码）
 * <p>Title: FormAuthenticationFilter</p>
 * <p>Description: </p>
 *
 * @Author:vincent
 * @Description:
 * @Date:Create in 下午 4:19 2018/1/15 0015
 */
@Service
public class FormAuthenticationFilter extends org.apache.shiro.web.filter.authc.FormAuthenticationFilter {

    /**
     * 创建令牌
     *
     * @param request
     * @param response
     * @return
     */
    @Override
    protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) {
        String username = WebUtils.getCleanParam(request, "loginId");
        String validateCode = WebUtils.getCleanParam(request, "validateCode");
        String password = DigestUtils.md5DigestAsHex(WebUtils.getCleanParam(request, "loginPwd").getBytes());
        boolean rememberMe = "on".equals(WebUtils.getCleanParam(request, "isRemember"));
        String host = StringUtils.getRemoteAddress((HttpServletRequest) request);
        boolean auto="on".equals(WebUtils.getCleanParam(request,"isAuto"));
        return new UsernamePasswordToken(username, password, rememberMe, host, validateCode,auto);
    }

    /**
     * 登录成功后跳转
     * @param request
     * @param response
     * @throws Exception
     */
    @Override
    protected void issueSuccessRedirect(ServletRequest request, ServletResponse response) throws Exception {
        LoginDTO principal = AdminUtils.getPrincipal();
        if(principal!=null){
            WebUtils.issueRedirect(request,response,"/main",null,true);
        }
    }

    /**
     * 登录失败调用事件
     * @param token
     * @param e
     * @param request
     * @param response
     * @return
     */
    @Override
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
        String className = e.getClass().getName();

        if(IncorrectCredentialsException.class.getName().equals(className) || UnknownAccountException.class.getName().equals(className)){
            request.setAttribute("message","用户名或密码错误，请重试");
        }
        return true;
    }
}