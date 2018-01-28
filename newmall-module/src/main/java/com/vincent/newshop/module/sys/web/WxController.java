package com.vincent.newshop.module.sys.web;

import com.vincent.newshop.common.utils.WechatJsUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @Author:vincent
 * @Description:
 * @Date:Create in 下午 8:04 2018/1/13 0013
 */
@Controller
public class WxController {

    @RequestMapping(value = "weixin",method = RequestMethod.GET)
    public String toWx(Model model){
        //WechatJsUtil.sign()
        Map<String, String> sign = WechatJsUtil.sign("http://1964y433d1.iok.la/weixin",model);
        return "modules/sys/wx";
    }

    @RequestMapping(value = "weixin",method = RequestMethod.POST)
    public void initConfig(String url, HttpServletResponse response, Model model) throws IOException {
        Map<String, String> sign = WechatJsUtil.sign(url,model);

        response.getWriter().write(sign.toString());
    }

}
