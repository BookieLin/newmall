package com.vincent.newshop.module.sys.interceptor;


import com.vincent.newshop.common.utils.UserAgentUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author:vincent
 * @Description:
 * @Date:Create in 下午 4:05 2018/1/12 0012
 */
public class DeviceInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        if (UserAgentUtils.isMobile(httpServletRequest) && modelAndView!=null && !StringUtils.startsWith(modelAndView.getViewName(), "redirect:")) {

            modelAndView.setViewName("mobile" + modelAndView.getViewName().replace("modules", ""));

        }
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
