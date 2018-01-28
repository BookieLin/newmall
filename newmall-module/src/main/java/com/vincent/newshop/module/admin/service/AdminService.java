package com.vincent.newshop.module.admin.service;

import com.vincent.newshop.module.admin.vo.AdminVO;
import com.vincent.newshop.module.sys.dto.LoginDTO;
import com.vincent.newshop.module.admin.entity.Admin;

import java.io.PrintWriter;
import java.util.List;

/**
 * @Author:vincent
 * @Description:
 * @Date:Create in 下午 4:01 2018/1/8 0008
 */
public interface AdminService {

    Admin login(LoginDTO loginDTO);

    Admin getById(Long id);

    String save(Admin admin);

    boolean checkSave(Admin admin, PrintWriter printWriter);

    List<Admin> queryAdmin();

    int updateOne(Admin admin);

    int removeOne(Admin admin);

    Admin getByLoginId(String username);
}
