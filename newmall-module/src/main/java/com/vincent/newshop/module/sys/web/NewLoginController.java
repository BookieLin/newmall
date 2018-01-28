package com.vincent.newshop.module.sys.web;

import com.vincent.newshop.common.utils.IDUtils;
import com.vincent.newshop.module.sys.dto.LoginDTO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author:vincent
 * @Description:
 * @Date:Create in 下午 1:23 2018/1/15 0015
 */
@Controller
public class NewLoginController {

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        // 真正的登录逻辑不在此 Controller 中，所以这里的 login 请求只是为了判断用户是否已经登录
        LoginDTO loginDTO = getPrincipal();

        // 如果已登录则跳转管理首页
        if (loginDTO != null) {
            return "redirect:/main";
        }

        return "modules/sys/login";
    }

    /**
     * 登录失败的处理，真正 POST 请求在过滤器中完成
     *
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String loginFail(HttpServletRequest request) {
        // 验证失败清空验证码
        request.getSession().setAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY, IDUtils.genId());
        return "modules/sys/login";
    }

    /**
     * 获取当前登录对象
     *
     * @return
     */
    private LoginDTO getPrincipal() {
        Subject subject = SecurityUtils.getSubject();
        LoginDTO loginDTO = (LoginDTO) subject.getPrincipal();
        if (loginDTO != null) {
            return loginDTO;
        }
        return null;
    }


}