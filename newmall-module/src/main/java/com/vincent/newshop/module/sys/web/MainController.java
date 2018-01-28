package com.vincent.newshop.module.sys.web;

import com.vincent.newshop.common.utils.IDUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author:vincent
 * @Description:
 * @Date:Create in 下午 4:38 2018/1/8 0008
 */
@Controller
public class MainController {

    @RequestMapping(value = {"","main"},method = RequestMethod.GET)
    public String main(){
        return "modules/sys/index";
    }


}
