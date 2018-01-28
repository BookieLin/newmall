package com.vincent.newshop.module.sys.interceptor;

import com.vincent.newshop.module.admin.utils.AdminUtils;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author:vincent
 * @Description:
 * @Date:Create in 下午 6:58 2018/1/8 0008
 */

public class PermissionInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        if (AdminUtils.getAdmin(httpServletRequest.getSession()) == null) {
            //打印记录
            httpServletResponse.sendRedirect("/login");
            return false;
        }
        //打印记录
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
