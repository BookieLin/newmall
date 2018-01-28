package com.vincent.newshop.common.utils;

import org.springframework.ui.Model;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * title:WechatJsUtil
 *
 * @author: 汤杰铖
 * @create: 2018-01-13 下午 7:50
 **/
public class WechatJsUtil {


    public static Map<String, String> sign(String url, Model model){
        Map<String, String> ret = new HashMap<String, String>();
        String accessToken = WechatUtil.getAccessToken();
        String jsapi_ticket = WechatUtil.getJSAPITicket(accessToken);
        String nonce_str = create_nonce_str();
        String timestamp = create_timestamp();
        String string1;
        String signature = "";

        //注意这里参数名必须全部小写，且必须有序
        string1 = "jsapi_ticket=" + jsapi_ticket +
                "&noncestr=" + nonce_str +
                "&timestamp=" + timestamp +
                "&url=" + url;

        try
        {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(string1.getBytes("UTF-8"));
            signature = byteToHex(crypt.digest());
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }

        model.addAttribute("url", url);
        model.addAttribute("jsapi_ticket", jsapi_ticket);
        model.addAttribute("nonceStr", nonce_str);
        model.addAttribute("timestamp", timestamp);
        model.addAttribute("signature", signature);

        ret.put("url", url);
        ret.put("jsapi_ticket", jsapi_ticket);
        ret.put("nonceStr", nonce_str);
        ret.put("timestamp", timestamp);
        ret.put("signature", signature);

        System.out.println(ret);
        return ret;

    }

    private static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash)
        {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }

    private static String create_nonce_str() {
        return UUID.randomUUID().toString();
    }

    private static String create_timestamp() {
        return Long.toString(System.currentTimeMillis() / 1000);
    }

}
