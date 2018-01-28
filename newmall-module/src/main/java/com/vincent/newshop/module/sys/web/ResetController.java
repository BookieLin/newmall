package com.vincent.newshop.module.sys.web;

import com.vincent.newshop.module.admin.entity.Admin;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author:vincent
 * @Description:
 * @Date:Create in 上午 12:13 2018/1/9 0009
 */
@Controller
public class ResetController {

    @RequestMapping(value = "reset", method = RequestMethod.GET)
    public String reset() {
        return "modules/sys/reset";
    }

    @RequestMapping(value = "reset", method = RequestMethod.POST)
    public void reset(Admin loginDTO) {

    }
    @RequestMapping(value = "reset2", method = RequestMethod.GET)
    public String reset2() {
        return "modules/sys/reset2";
    }
}
