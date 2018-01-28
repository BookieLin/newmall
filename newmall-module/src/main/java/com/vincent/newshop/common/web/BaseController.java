package com.vincent.newshop.common.web;

import com.google.gson.JsonObject;
import com.vincent.newshop.common.validator.BeanValidators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.io.PrintWriter;
import java.util.List;

/**
 * 控制器支持类
 * <p>Title: BaseController</p>
 * <p>Description: </p>
 *
 * @Author:vincent
 * @Description:
 * @Date:Create in 下午 1:41 2018/1/10 0010
 */
public abstract class BaseController {
    /**
     * 验证 Bean 实例对象
     */
    @Autowired
    protected Validator validator;


    protected boolean myValidator(Object param, Object object, Class<?>... groups) {
        if (param instanceof Model) {
            return beanValidator((Model) param, object, groups);
        }
        else if (param instanceof RedirectAttributes){
            return beanValidator((RedirectAttributes) param, object, groups);
        }
        else{
            return beanValidator((PrintWriter)param,object,groups);
        }
    }


    /**
     * 服务端参数有效性验证
     *
     * @param object 验证的实体对象
     * @param groups 验证组
     * @return 验证成功：返回true；验证失败：将错误信息添加到 message 中
     */
    private boolean beanValidator(Model model, Object object, Class<?>... groups) {
        try {
            BeanValidators.validateWithException(validator, object, groups);
        } catch (ConstraintViolationException ex) {
            List<String> list = BeanValidators.extractMessage(ex);
            list.add(0, "数据验证失败：");
            addMessage(model, list.toArray(new String[]{}));
            return false;
        }
        return true;
    }
    /**
     * ajax请求
     * 服务端参数有效性验证
     *
     * @param object 验证的实体对象
     * @param groups 验证组
     * @return 验证成功：返回true；验证失败：将错误信息添加到 message 中
     */
    private boolean beanValidator(PrintWriter writer, Object object, Class<?>... groups) {
        try {
            BeanValidators.validateWithException(validator, object, groups);
        } catch (ConstraintViolationException ex) {
            List<String> list = BeanValidators.extractMessage(ex);
            addMessage(writer, list.toArray(new String[]{}));
            return false;
        }
        return true;
    }

    /**
     * 服务端参数有效性验证
     *
     * @param object 验证的实体对象
     * @param groups 验证组
     * @return 验证成功：返回true；证失败：将错误信息添加到 flash message 中
     */
    private boolean beanValidator(RedirectAttributes redirectAttributes, Object object, Class<?>... groups) {
        try {
            BeanValidators.validateWithException(validator, object, groups);
        } catch (ConstraintViolationException ex) {
//            List<String> list = BeanValidators.extractPropertyAndMessageAsList(ex, ": ");
            List<String> list = BeanValidators.extractMessage(ex);
            list.add(0, "数据验证失败：");
            addMessage(redirectAttributes, list.toArray(new String[]{}));
            return false;
        }
        return true;
    }

    /**
     * 服务端参数有效性验证
     *
     * @param object 验证的实体对象
     * @param groups 验证组，不传入此参数时，同 @Valid 注解验证
     * @return 验证成功：继续执行；验证失败：抛出异常跳转400页面。
     */
    protected void beanValidator(Object object, Class<?>... groups) {
        BeanValidators.validateWithException(validator, object, groups);
    }

    /**
     * 添加 Model 消息
     *
     * @param messages
     */
    private void addMessage(Model model, String... messages) {
        StringBuilder sb = new StringBuilder();
        for (String message : messages) {
            sb.append(message).append(messages.length > 1 ? "<br/>" : "");
        }
        model.addAttribute("message", sb.toString());

    }

    /**
     * ajax请求添加Json消息
     * @param writer
     * @param messages
     */
    private void addMessage(PrintWriter writer,String... messages){
        JsonObject jsonObject=new JsonObject();
        int i;
        for (String message : messages) {
            String[] split = message.split(":");
            jsonObject.addProperty(split[0],split[1]);
        }
        writer.write(jsonObject.toString());
    }
    /**
     * 添加 Flash 消息
     *
     * @param messages
     */
    private void addMessage(RedirectAttributes redirectAttributes, String... messages) {
        StringBuilder sb = new StringBuilder();
        for (String message : messages) {
            sb.append(message).append(messages.length > 1 ? "<br/>" : "");
        }
        redirectAttributes.addFlashAttribute("message", sb.toString());
    }
}
