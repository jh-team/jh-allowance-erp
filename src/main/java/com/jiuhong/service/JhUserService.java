package com.jiuhong.service;

import com.github.pagehelper.PageInfo;
import com.jiuhong.model.JhUserInfo;

/**
*
*@Description 用户业务处理逻辑层
*@Author wuxiaoyang
*@Date 2018/10/15
*
*/
public interface JhUserService extends BaseService<JhUserInfo>{
    /**
     * 分页查询
     * @param jhUserInfo 用户信息
     * @param start 起始下标
     * @param length 长度
     * @return
     */
    PageInfo<JhUserInfo> selectByPage(JhUserInfo jhUserInfo, int start, int length);

    /**
     * 通过用户名称查询用户信息
     * @param username
     * @return
     */
    JhUserInfo selectByUsername(String username);

    /**
     * 删除用户
     * @param userid
     */
    void delUser(Integer userid);

}
