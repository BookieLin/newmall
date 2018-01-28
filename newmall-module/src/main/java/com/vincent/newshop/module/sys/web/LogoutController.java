package com.vincent.newshop.module.sys.web;

import com.vincent.newshop.common.utils.CookieUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author:vincent
 * @Description:
 * @Date:Create in 下午 9:39 2018/1/8 0008
 */
@Controller
public class LogoutController {

    @RequestMapping(value = "logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        //打印记录
        SecurityUtils.getSubject().logout();
        HttpSession session = request.getSession();
        session.invalidate();
        String auto = CookieUtils.getCookieValue(request, "auto", "UTF-8");
        if ("yes".equalsIgnoreCase(auto)) {
            CookieUtils.setCookie(request, response, "auto", "no");
        }
        return "redirect:/tologin";
    }
}
