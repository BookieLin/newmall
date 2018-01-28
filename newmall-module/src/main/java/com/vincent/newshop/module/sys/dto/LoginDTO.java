package com.vincent.newshop.module.sys.dto;

import java.io.Serializable;

/**
 * @Author:vincent
 * @Description:
 * @Date:Create in 上午 11:54 2018/1/9 0009
 */
public class LoginDTO implements Serializable {

    private String loginId;
    private String loginPwd;
    private String isRemember;
    private String isAuto;
    private String Validate;

    public LoginDTO() {
    }

    public LoginDTO(String loginId, String loginPwd, String isRemember, String isAuto, String validate) {
        this.loginId = loginId;
        this.loginPwd = loginPwd;
        this.isRemember = isRemember;
        this.isAuto = isAuto;
        Validate = validate;
    }

    public LoginDTO(String loginId, String loginPwd, String isRemember, String isAuto) {
        this.loginId = loginId;
        this.loginPwd = loginPwd;
        this.isRemember = isRemember;
        this.isAuto = isAuto;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getIsRemember() {
        return isRemember;
    }

    public void setIsRemember(String isRemember) {
        this.isRemember = isRemember;
    }

    public String getIsAuto() {
        return isAuto;
    }

    public void setIsAuto(String isAuto) {
        this.isAuto = isAuto;
    }

    public String getValidate() {
        return Validate;
    }

    public void setValidate(String validate) {
        Validate = validate;
    }
}
