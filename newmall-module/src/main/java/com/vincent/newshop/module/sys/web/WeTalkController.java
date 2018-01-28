package com.vincent.newshop.module.sys.web;

import com.vincent.newshop.module.admin.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author:vincent
 * @Description:
 * @Date:Create in 上午 1:24 2018/1/15 0015
 */
@Controller
public class WeTalkController {


    @RequestMapping(value = "wetalk",method = RequestMethod.POST)
    public void saveTalk(String res, HttpServletRequest request){
        System.out.println(res);
    }
}
