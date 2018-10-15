package com.jiuhong.util;


import com.jiuhong.model.JhUserInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @Description 密码加密处理
 * @Author wuxiaoyang
 * @Date 2018/10/15
 */
public class PasswordHelper {
    private String algorithmName = "md5";
    private int hashIterations = 2;

    public void encryptPassword(JhUserInfo jhUserInfo) {
        String newPassword = new SimpleHash(algorithmName, jhUserInfo.getPassword(), ByteSource.Util.bytes(jhUserInfo.getUsername()), hashIterations).toHex();
        jhUserInfo.setPassword(newPassword);

    }

    public static void main(String[] args) {
        PasswordHelper passwordHelper = new PasswordHelper();
        JhUserInfo jhUserInfo = new JhUserInfo();
        jhUserInfo.setUsername("admin");
        jhUserInfo.setPassword("admin");
        passwordHelper.encryptPassword(jhUserInfo);
        System.out.println(jhUserInfo);
    }
}
