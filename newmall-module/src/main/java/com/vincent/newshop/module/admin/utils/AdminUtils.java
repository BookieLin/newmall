package com.vincent.newshop.module.admin.utils;

import com.vincent.newshop.module.admin.entity.Admin;
import com.vincent.newshop.module.sys.dto.LoginDTO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import javax.servlet.http.HttpSession;

/**
 * @Author:vincent
 * @Description:
 * @Date:Create in 下午 5:09 2018/1/8 0008
 */
public class AdminUtils {

    public static Admin getAdmin(HttpSession session){
       return (Admin) session.getAttribute("admin");
    }
    /**
     * 获取当前登录对象
     *
     * @return
     */
    public static LoginDTO getPrincipal(){
        Subject subject = SecurityUtils.getSubject();
        return  (LoginDTO) subject.getPrincipal();
    }


}
