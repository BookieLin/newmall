package com.vincent.newshop.module.sys.web;

import com.google.common.collect.Maps;

import com.vincent.newshop.common.utils.CookieUtils;
import com.vincent.newshop.common.utils.Des;
import com.vincent.newshop.module.sys.dto.LoginDTO;
import com.vincent.newshop.module.admin.entity.Admin;
import com.vincent.newshop.module.admin.service.AdminService;

import org.apache.commons.lang.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * @Author:vincent
 * @Description:
 * @Date:Create in 下午 3:09 2018/1/8 0008
 */
@Controller
public class LoginController {

    public final static String COOKIE_USER = "admin";
    public final static String COOKIE_AUTO = "auto";
    public final static String MESSAGE = "message";

    @Autowired
    private AdminService adminService;

    public static Map<String, String> tokenMap = Maps.newHashMap();


    @RequestMapping(value = "tologin", method = RequestMethod.GET)
    public String tologin(HttpServletRequest request, Model model) {
        String token = Des.makeToken();
        tokenMap.put(token.toString(), token);
        request.getSession().setAttribute("token", token);
        String user = CookieUtils.getCookieValue(request, COOKIE_USER);

        try {
            if(user!=null) {
                String[] split = Des.decrypt(user).split("[+]");
                model.addAttribute("username", split[0]);
                model.addAttribute("password", split[1]);
            }
            model.addAttribute(COOKIE_USER, CookieUtils.getCookieValue(request, COOKIE_USER));
            model.addAttribute(COOKIE_AUTO, CookieUtils.getCookieValue(request, COOKIE_AUTO));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //打印记录
        return "modules/sys/login";
    }

    @RequestMapping(value = "waiting", method = RequestMethod.GET)
    public String waitResponse(HttpSession session) throws InterruptedException {
        //Thread.sleep(10000);
        if (session.getAttribute("admin") == null) {
            return "redirect:/tologin";
        } else {
            return "redirect:/main";
        }
    }


    public String login(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String user = CookieUtils.getCookieValue(request, LoginController.COOKIE_USER, "UTF-8");
        if (StringUtils.isNotBlank(user)) {

            String auto = CookieUtils.getCookieValue(request, LoginController.COOKIE_AUTO, "UTF-8");
            if ("yes".equals(auto)) {
                //打印记录

                return "redirect:/autologin";
            } else if ("no".equals(auto)) {
                CookieUtils.deleteCookie(request, response, LoginController.COOKIE_AUTO);
                request.setAttribute(LoginController.COOKIE_AUTO, "no");
            }

            //打印记录
        }


        //打印记录
        return "redirect:/tologin";
    }


    public String login(LoginDTO loginDTO, RedirectAttributes redirectAttributes, HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        Object token = session.getAttribute("token");
        if (token == null || tokenMap.get(token.toString()) == null) {
            return "redirect:/waiting";
        }
        session.removeAttribute("token");
        //Thread.sleep(6000);
        //System.out.println("1111");
        if (checkLogin(loginDTO, redirectAttributes)) {
            if(!loginDTO.getValidate().equals(request.getSession().getAttribute(KAPTCHA_SESSION_KEY))){
                redirectAttributes.addFlashAttribute(MESSAGE, "验证码不正确");
                return "redirect:/tologin";
            }
            Admin result;
            if ((result = adminService.login(loginDTO)) == null) {
                //打印记录
                redirectAttributes.addFlashAttribute(MESSAGE, "用户名密码不正确");
            } else {
                //打印记录
                request.getSession().setAttribute(COOKIE_USER, result);

                String user = String.format("%s+%s", loginDTO.getLoginId(), loginDTO.getLoginPwd());
                if (!isAuto(loginDTO, request, response, Des.encrypt(user))) {
                    isRemember(loginDTO, request, response, COOKIE_USER, Des.encrypt(user));
                }

                return "redirect:/main";
            }
        }
        //打印记录
        return "redirect:/tologin";
    }


    @RequestMapping(value = "autologin", method = RequestMethod.GET)
    public String autologin(HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) throws Exception {
        //打印记录
        String user = CookieUtils.getCookieValue(request, COOKIE_USER, "UTF-8");
        String code = Des.decrypt(user);
        String[] str = code.split("[+]");
        String username = str[0];
        String password = str[1];
        //打印记录
        LoginDTO loginDTO = new LoginDTO(username, password, "on", "yes");
        Admin result;
        if ((result = adminService.login(loginDTO)) == null) {
            //打印记录
            redirectAttributes.addFlashAttribute(MESSAGE, "用户名密码不正确");
        } else {
            //打印记录
            request.getSession().setAttribute(COOKIE_USER, result);
            return "redirect:/main";
        }

        //打印记录
        return "redirect:/login";
    }

    private boolean isAuto(LoginDTO loginDTO, HttpServletRequest request, HttpServletResponse response, String encrypt) {
        if (StringUtils.isNotBlank(loginDTO.getIsAuto())) {
            //打印记录
            CookieUtils.setCookie(request, response, COOKIE_AUTO, "yes", 60 * 60 * 24 * 7, "UTF-8");
            CookieUtils.setCookie(request, response, COOKIE_USER, encrypt, 60 * 60 * 24 * 7);
            return true;
        } else {
            CookieUtils.deleteCookie(request, response, COOKIE_AUTO);
            //打印记录
            return false;
        }
    }

    private boolean isRemember(LoginDTO loginDTO, HttpServletRequest request, HttpServletResponse response, String rememberMe, String encrypt) throws Exception {
        if (StringUtils.isNotBlank(loginDTO.getIsRemember())) {
            //打印记录
            CookieUtils.setCookie(request, response, COOKIE_USER, encrypt, 60 * 60);
            return true;
        } else {
            //打印记录
            CookieUtils.deleteCookie(request, response, COOKIE_USER);
            return false;
        }
    }

    private boolean checkLogin(LoginDTO loginDTO, RedirectAttributes redirectAttributes) {
        if (loginDTO == null || StringUtils.isBlank(loginDTO.getLoginPwd()) || StringUtils.isBlank(loginDTO.getLoginId()) || StringUtils.isBlank(loginDTO.getValidate())) {
            //打印记录
            redirectAttributes.addFlashAttribute(MESSAGE, "用户名密码验证码不能为空");
            return false;
            //打印记录
        }
        //打印记录
        return true;
    }
}
