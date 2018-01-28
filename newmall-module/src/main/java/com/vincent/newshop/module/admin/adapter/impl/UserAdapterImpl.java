package com.vincent.newshop.module.admin.adapter.impl;


import com.google.common.collect.Lists;
import com.vincent.newshop.module.admin.adapter.UserAdapter;
import com.vincent.newshop.module.sys.dto.LoginDTO;

import com.vincent.newshop.module.admin.entity.Admin;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;


import java.util.List;

/**
 * @Author:vincent
 * @Description:
 * @Date:Create in 下午 10:02 2017/12/31 0031
 */
@Component
public class UserAdapterImpl implements UserAdapter {

    List<String> reg;

    public UserAdapterImpl() {
        if (reg == null) {
            reg = Lists.newArrayList();
            reg.add("\\w+(\\.\\w)*@\\w+(\\.\\w{2,3}){1,3}");//邮箱
            reg.add("^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$");
        }
    }

    @Override
    public Example getExamPle(LoginDTO loginDTO) {
        Example example = new Example(Admin.class);
        String username=loginDTO.getLoginId();
        //打印记录
        checkRepeat(example, username);
        //打印记录
        return example;
    }

    @Override
    public Example getExamPle(String username) {
        Example example = new Example(Admin.class);

        //打印记录
        checkRepeat(example, username);
        //打印记录
        return example;
    }

    private void checkRepeat(Example example, String username) {
        if (username.matches(reg.get(0))) {
            //打印记录
            example.createCriteria().andEqualTo("email", username);
        }

        else if (username.matches(reg.get(1))) {
            //打印记录
            example.createCriteria().andEqualTo("phone", username);
        }

        else{
            //打印记录
            example.createCriteria().andEqualTo("username", username);
        }
    }

}
