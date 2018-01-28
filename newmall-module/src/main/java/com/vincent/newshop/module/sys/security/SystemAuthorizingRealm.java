package com.vincent.newshop.module.sys.security;

import com.vincent.newshop.module.admin.adapter.UserAdapter;
import com.vincent.newshop.module.admin.entity.Admin;
import com.vincent.newshop.module.admin.service.AdminService;
import com.vincent.newshop.module.sys.dto.LoginDTO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;

import org.apache.shiro.authc.SimpleAuthenticationInfo;

import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @Author:vincent
 * @Description:
 * @Date:Create in 下午 4:26 2018/1/15 0015
 */
@Service
public class SystemAuthorizingRealm extends AuthorizingRealm {

    @Autowired
    private UserAdapter userAdapter;
    @Autowired
    private AdminService adminService;

    /**
     * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 认证回调函数, 登录时调用
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        Admin admin = adminService.getByLoginId(usernamePasswordToken.getUsername());
        if (admin != null) {
            String loginId = usernamePasswordToken.getUsername();
            String loginPwd = new String(usernamePasswordToken.getPassword());
            String isRemember = usernamePasswordToken.isRememberMe() ? "on" : "";
            String validateCode = usernamePasswordToken.getValidateCode();
            String auto = usernamePasswordToken.isAuto() ? "on" : "";
            return new SimpleAuthenticationInfo(new LoginDTO(loginId, loginPwd, isRemember,auto ,validateCode), admin.getPassword(), admin.getName());
        }
        return null;
    }

    /**
     * 获取 Shiro 管理的 Session
     *
     * @return
     */
    private Session getSession() {
        Subject subject = SecurityUtils.getSubject();
        // 是否创建新会话
        Session session = subject.getSession(false);
        if (session == null) {
            session = subject.getSession();
        }
        return session;
    }
}