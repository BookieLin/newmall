package com.vincent.newshop.module.admin.service.impl;

import com.google.gson.JsonObject;
import com.vincent.newshop.module.admin.adapter.UserAdapter;
import com.vincent.newshop.common.utils.Des;
import com.vincent.newshop.common.utils.IDUtils;
import com.vincent.newshop.module.admin.vo.AdminVO;
import com.vincent.newshop.module.sys.dto.LoginDTO;
import com.vincent.newshop.module.admin.dao.AdminMapper;
import com.vincent.newshop.module.admin.entity.Admin;
import com.vincent.newshop.module.admin.service.AdminService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;


import java.io.PrintWriter;
import java.util.List;

/**
 * @Author:vincent
 * @Description:
 * @Date:Create in 下午 4:02 2018/1/8 0008
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private UserAdapter userAdapter;

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin login(LoginDTO loginDTO) {
        Admin result = null;
        List<Admin> loginDTOS = adminMapper.selectByExample(userAdapter.getExamPle(loginDTO));

        if (loginDTOS != null && loginDTOS.size() == 1) {
            result = loginDTOS.get(0);
            if (result.getPassword().equalsIgnoreCase(Des.MD5(loginDTO.getLoginPwd()))) {
                //打印记录
                return result;
            }
            //打印记录
        } else {
            //打印记录
        }

        return null;
    }

    @Override
    public Admin getById(Long id) {
        Admin result = null;
        Example example = new Example(Admin.class);
        example.createCriteria().andEqualTo("id", id);

        List<Admin> admins = adminMapper.selectByExample(example);
        if (admins != null && admins.size() == 1) {
            result = admins.get(0);
            return result;
            //打印记录
        } else {
            //打印记录
        }

        return null;
    }

    @Override
    public String save(Admin admin) {
        if (admin.getId() != null) {
            String password = admin.getPassword();
            if (StringUtils.isBlank(password)) {
                admin.setPassword(null);
            } else {
                admin.setPassword(Des.MD5(password));
            }
            adminMapper.updateByPrimaryKeySelective(admin);
        } else {
            Admin result = adminMapper.checkAdd(admin);
            if (result == null) {
                admin.setId(IDUtils.genId());
                admin.setPassword(Des.MD5(admin.getPassword()));
                adminMapper.insert(admin);
                return "redirect:/main?save=ok";
            }

        }
        return "redirect:/main?save=no";
    }

    @Override
    public boolean checkSave(Admin admin, PrintWriter writer) {
        String check = admin.getUsername();
        List<Admin> admins = adminMapper.selectByExample(userAdapter.getExamPle(check));
        JsonObject json = new JsonObject();
        boolean flag = true;
        if (HandleResult(admin, admins)) {
            json.addProperty("username", "用户名已经存在");
            flag = false;
        }

        check = admin.getEmail();
        admins = adminMapper.selectByExample(userAdapter.getExamPle(check));
        if (HandleResult(admin, admins)) {
            //writer.write("{\"email\":\"邮箱已经存在\"}");
            json.addProperty("email", "邮箱已经存在");
            flag = false;
        }

        check = admin.getPhone();
        admins = adminMapper.selectByExample(userAdapter.getExamPle(check));
        if (HandleResult(admin, admins)) {
            //writer.write("{\"phone\":\"手机号已经存在\"}");
            json.addProperty("phone", "手机号已经存在");
            flag = false;
        }
        if (!flag) {
            writer.write(json.toString());
        }

        if (admin.getId() == null) {
            writer.write("add_success");
        }
        return flag;
    }

    @Override
    public List<Admin> queryAdmin() {
        return adminMapper.selectAll();
    }

    @Override
    public int updateOne(Admin admin) {
        return adminMapper.updateByPrimaryKeySelective(admin);
    }

    @Override
    public int removeOne(Admin admin) {
        return adminMapper.deleteByPrimaryKey(admin);
    }

    @Override
    public Admin getByLoginId(String username) {
        Example example = new Example(Admin.class);
        example.createCriteria()
                .andEqualTo("username", username)
                .orEqualTo("phone", username)
                .orEqualTo("email", username);
        List<Admin> admins = adminMapper.selectByExample(example);
        if (admins != null && admins.size() == 1) {
            return admins.get(0);
        }
        return null;
    }

    private boolean HandleResult(Admin admin, List<Admin> admins) {
        if (admins.size() > 1) {
            return true;
        } else if (admins.size() == 1) {
            Admin admin1 = admins.get(0);
            if (admin1.getId().equals(admin.getId())) {
                return false;
            } else {
                return true;
            }
        } else if (admins.size() == 0) {
            return false;
        }
        return true;
    }
}
