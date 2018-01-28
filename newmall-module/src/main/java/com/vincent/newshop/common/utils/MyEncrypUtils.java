package com.vincent.newshop.common.utils;

import java.util.Random;

/**
 * @Author:vincent
 * @Description:
 * @Date:Create in 下午 9:56 2018/1/12 0012
 */
public class MyEncrypUtils {

    private static Random random=new Random();
    public static Long encrypt(Long id){
        char[] chars = id.toString().toCharArray();
        int length=chars.length/2;
        if(chars.length%2!=0){
            length++;
        }
        for(int i=0;i<length;i++){
            char t=(char)(chars[i]+48);
            chars[i]=(char)(chars[chars.length-i-1]+48);
            chars[chars.length-i-1]=t;
        }
        for(int i=0;i<chars.length;i++){
            chars[i]-=48;
        }

        int min=10+random.nextInt(69);
        int max=10+random.nextInt(89);
        String s = new String(chars);
        s=min+s+max;
        return Long.parseLong(s);
    }
    public static Long decrpt(Long id){
        String s = id.toString();
        String substring = s.substring(2, s.length() - 2);
        char[] chars = substring.toCharArray();
        int length=chars.length/2;
        if(chars.length%2!=0){
            length++;
        }
        for(int i=0;i<length;i++){
            char t=chars[i];
            chars[i]=chars[chars.length-i-1];
            chars[chars.length-i-1]=t;
        }
        return Long.parseLong(new String(chars));
    }
}
