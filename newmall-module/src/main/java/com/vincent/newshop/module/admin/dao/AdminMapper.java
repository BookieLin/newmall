package com.vincent.newshop.module.admin.dao;


import com.vincent.newshop.module.admin.entity.Admin;
import tk.mybatis.mapper.DaoMapper;

import java.util.List;


public interface AdminMapper extends DaoMapper<Admin> {


    Admin checkAdd(Admin admin);
}