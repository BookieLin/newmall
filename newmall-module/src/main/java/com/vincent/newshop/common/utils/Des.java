package com.vincent.newshop.common.utils;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;



public class Des {

    private static final String PASSWORD_CRYPT_KEY = "HUSHAOIkjhihoiDSAHOFJSOAJI798syfdh8qwhy 9nc8*( NH98d iusahfiu 9saA H9FDHA9S FD";

    private final static String ALGORITHM = "DES";

    public static String makeToken(){  //checkException
        //  7346734837483  834u938493493849384  43434384
        String token = (System.currentTimeMillis() + new Random().nextInt(999999999)) + "";
        //数据指纹   128位长   16个字节  md5
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            byte md5[] =  md.digest(token.getBytes());
            //base64编码--任意二进制编码明文字符   adfsdfsdfsf

            BASE64Encoder encoder = new BASE64Encoder();
            return encrypt(encoder.encode(md5).substring(0,10));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //解密
    public final static String decrypt(String data) throws Exception {
        return new String(decrypt(hex2byte(data.getBytes()),
                PASSWORD_CRYPT_KEY.getBytes()));
    }

    //加密
    public final static String encrypt(String data) throws Exception  {
        return byte2hex(encrypt(data.getBytes(), PASSWORD_CRYPT_KEY
                .getBytes()));
    }
    

    private static byte[] encrypt(byte[] data, byte[] key) throws Exception {
        
        SecureRandom sr = new SecureRandom();
      
        DESKeySpec dks = new DESKeySpec(key);
     
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
        SecretKey securekey = keyFactory.generateSecret(dks);
      
        Cipher cipher = Cipher.getInstance(ALGORITHM);
  
        cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);
   
        return cipher.doFinal(data);
    }

    public static byte[] aesEncryptToBytes(String content, String encryptKey) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        kgen.init(128, new SecureRandom(encryptKey.getBytes()));

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(kgen.generateKey().getEncoded(), "AES"));

        return cipher.doFinal(content.getBytes("utf-8"));
    }

    public static String aesDecryptByBytes(byte[] encryptBytes, String decryptKey) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        kgen.init(128, new SecureRandom(decryptKey.getBytes()));

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(kgen.generateKey().getEncoded(), "AES"));
        byte[] decryptBytes = cipher.doFinal(encryptBytes);

        return new String(decryptBytes);
    }

    private static byte[] decrypt(byte[] data, byte[] key) throws Exception {
    
        SecureRandom sr = new SecureRandom();
     
        DESKeySpec dks = new DESKeySpec(key);
 
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
        SecretKey securekey = keyFactory.generateSecret(dks);

        Cipher cipher = Cipher.getInstance(ALGORITHM);

        cipher.init(Cipher.DECRYPT_MODE, securekey, sr);
 
        return cipher.doFinal(data);
    }

    public static byte[] hex2byte(byte[] b) {
        if ((b.length % 2) != 0)
            throw new IllegalArgumentException("���Ȳ���ż��");
        byte[] b2 = new byte[b.length / 2];
        for (int n = 0; n < b.length; n += 2) {
            String item = new String(b, n, 2);
            b2[n / 2] = (byte) Integer.parseInt(item, 16);
        }
        return b2;
    }

    public static String byte2hex(byte[] b) {
        String hs = "";
        String stmp = "";

        for (int n = 0; n < b.length; n++) {
            stmp = (Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1)
                hs = hs + "0" + stmp;
            else
                hs = hs + stmp;
        }
        return hs.toUpperCase();
    }
    
    public static String MD5(String s) {  
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};         
  
        try {  
            byte[] btInput = s.getBytes();  
            // 获得MD5摘要算法的 MessageDigest 对象  
            MessageDigest mdInst = MessageDigest.getInstance("MD5");  
            // 使用指定的字节更新摘要  
            mdInst.update(btInput);  
            // 获得密文  
            byte[] md = mdInst.digest();  
            // 把密文转换成十六进制的字符串形式  
            int j = md.length;  
            char str[] = new char[j * 2];  
            int k = 0;  
            for (int i = 0; i < j; i++) {  
                byte byte0 = md[i];  
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];  
                str[k++] = hexDigits[byte0 & 0xf];  
            }  
            return new String(str);  
        } catch (Exception e) {  
            e.printStackTrace();  
            return null;  
        }  
    }  
}