package com.vincent.newshop.module.admin.vo;

import java.io.Serializable;

/**
 * @Author:vincent
 * @Description:
 * @Date:Create in 下午 9:34 2018/1/12 0012
 */
public class AdminVO implements Serializable {

    private String id;
    private String username;
    private String password;
    private String name;
    private String email;
    private String phone;

    public AdminVO() {
    }

    public AdminVO(String id, String username, String password, String name, String email, String phone) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
