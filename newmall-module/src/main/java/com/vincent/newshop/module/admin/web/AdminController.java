package com.vincent.newshop.module.admin.web;

import com.google.gson.JsonObject;
import com.vincent.newshop.common.utils.Des;
import com.vincent.newshop.common.utils.EncryptUtil;
import com.vincent.newshop.common.utils.MyEncrypUtils;
import com.vincent.newshop.common.web.BaseController;
import com.vincent.newshop.module.admin.entity.Admin;
import com.vincent.newshop.module.admin.service.AdminService;

import com.vincent.newshop.module.admin.vo.AdminVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


/**
 * @Author:vincent
 * @Description:
 * @Date:Create in 下午 6:09 2018/1/9 0009
 */
@Controller
@RequestMapping(value = "admin")
public class AdminController extends BaseController {

    @Autowired
    private AdminService adminService;

    private EncryptUtil encryptUtil=new EncryptUtil("9ba45bfd500642328ec03ad8ef1b6e75","utf-8");

    @RequestMapping(value = "toAdd")
    public String loadAdd() {
        return "modules/admin/add";
    }

    @RequestMapping(value = "toEditor")
    public String loadEditor() {
        return "modules/admin/editor";
    }

    @RequestMapping(value = "toTable")
    public String loadTable() {
        return "modules/admin/table";
    }

    @ModelAttribute
    public Admin getAdminById(@RequestParam(required = false) Long id) {
        Admin entity = null;

        if (id == null) {
            entity = new Admin();
        } else {
            entity = adminService.getById(id);
        }
        return entity;
    }


    @RequestMapping(value = "findAll", method = RequestMethod.POST)
    public void queryAdmin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Admin> admins = adminService.queryAdmin();
        for(Admin admin:admins){
            admin.setId(MyEncrypUtils.encrypt(admin.getId()));
        }
        request.getSession().setAttribute("list", admins);
        response.getWriter().write("");
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public void saveAdmin(@RequestBody Admin admin, HttpServletResponse response) throws IOException {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("data", "haha");
        PrintWriter writer = response.getWriter();
        if (myValidator(writer, admin)) {
            if (adminService.checkSave(admin, writer)) {
                adminService.save(admin);
            }

        }

    }

    @RequestMapping(value = "searchId", method = RequestMethod.POST)
    public void searchById(Long id, HttpServletResponse response) throws Exception {
        Admin admin = adminService.getById(id);
        response.getWriter().write(String.format("%s+%s+%s", admin.getUsername(), admin.getPhone(), admin.getEmail()));
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public void updateById(@RequestBody Admin admin, HttpServletResponse response) throws Exception {
        admin.setId(MyEncrypUtils.decrpt(admin.getId()));
        Integer i = adminService.updateOne(admin);
        response.getWriter().write(i.toString());
    }

    @RequestMapping(value = "del",method =RequestMethod.POST)
    public void removeById(@RequestBody Admin admin, HttpServletResponse response) throws Exception {
        admin.setId(MyEncrypUtils.decrpt(admin.getId()));
        Integer i=adminService.removeOne(admin);
        response.getWriter().write(i.toString());
    }
}
