package com.vincent.newshop.views.modules.jsp;

import com.vincent.utils.RecordWriter;
import org.junit.Test;

/**
 * @Author:vincent
 * @Description:
 * @Date:Create in 下午 8:39 2018/1/8 0008
 */
public class LoginTest {

    @Test
    public void makeRecord(){
        RecordWriter.getColumns("admin",20);
    }
}
