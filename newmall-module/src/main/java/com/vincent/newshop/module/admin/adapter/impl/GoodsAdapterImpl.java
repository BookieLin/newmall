package com.vincent.newshop.module.admin.adapter.impl;

import com.vincent.newshop.module.admin.adapter.GoodsAdapter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:vincent
 * @Description:
 * @Date:Create in 下午 2:31 2017/12/30 0030
 */
public class GoodsAdapterImpl implements GoodsAdapter {

    private List<Object> goodsService;

    public GoodsAdapterImpl() {
        if (goodsService == null) {
            goodsService = new ArrayList<>();
//            goodsService.add(BookService.class);
//            goodsService.add(FoodService.class);
//            goodsService.add(ComputerService.class);
        }

    }

    @Override
    public int addGoodsToCart(Object object) {
        for (Object obj : goodsService) {
            if (object.getClass().getSuperclass() == obj) {
                try {
                    Method addGoodsToCart = ((Class) obj).getDeclaredMethod("addGoodsToCart");
                    addGoodsToCart.invoke(object);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return 1;
    }
}
