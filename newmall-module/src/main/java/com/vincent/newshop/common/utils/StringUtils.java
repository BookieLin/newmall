package com.vincent.newshop.common.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author:vincent
 * @Description:
 * @Date:Create in 下午 1:39 2018/1/15 0015
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {
    /**
     * 获取用户远程地址
     * @param request
     * @return
     */
    public static String getRemoteAddress(HttpServletRequest request) {
        String remoteAddr = request.getHeader("X-Real-IP");
        if (isNotBlank(remoteAddr)) {
            remoteAddr = request.getHeader("X-Forwarded-For");
        } else if (isNotBlank(remoteAddr)) {
            remoteAddr = request.getHeader("Proxy-Client-IP");
        } else if (isNotBlank(remoteAddr)) {
            remoteAddr = request.getHeader("WL-Proxy-Client-IP");
        }
        return remoteAddr != null ? remoteAddr : request.getRemoteAddr();
    }
}
