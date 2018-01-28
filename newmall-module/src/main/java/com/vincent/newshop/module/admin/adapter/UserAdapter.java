package com.vincent.newshop.module.admin.adapter;


import com.vincent.newshop.module.sys.dto.LoginDTO;
import tk.mybatis.mapper.entity.Example;

/**
 * @Author:vincent
 * @Description:
 * @Date:Create in 上午 2:03 2017/12/30 0030
 */
public interface UserAdapter {

    Example getExamPle(LoginDTO loginDTO);

    Example getExamPle(String username);
}
