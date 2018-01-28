package com.vincent.newshop.module.sys.web;

import com.alibaba.druid.support.json.JSONUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author:vincent
 * @Description:
 * @Date:Create in 下午 5:31 2018/1/12 0012
 */
public class CodeController {

    @RequestMapping(value="send",method = RequestMethod.POST)
    public void sendMessage(HttpServletRequest request){
        
    }
}
