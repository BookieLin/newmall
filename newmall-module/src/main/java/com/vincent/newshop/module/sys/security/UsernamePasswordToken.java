package com.vincent.newshop.module.sys.security;

/**
 * @Author:vincent
 * @Description:
 * @Date:Create in 下午 4:32 2018/1/15 0015
 */
public class UsernamePasswordToken extends org.apache.shiro.authc.UsernamePasswordToken {

    private String validateCode;
    private boolean auto;

    public UsernamePasswordToken(String username, String password, boolean rememberMe, String host, String validateCode,boolean auto) {
        super(username, password, rememberMe, host);
        this.validateCode = validateCode;
        this.auto=auto;
    }

    public String getValidateCode() {
        return validateCode;
    }

    public void setValidateCode(String validateCode) {
        this.validateCode = validateCode;
    }

    public boolean isAuto() {
        return auto;
    }

    public void setAuto(boolean auto) {
        this.auto = auto;
    }
}
