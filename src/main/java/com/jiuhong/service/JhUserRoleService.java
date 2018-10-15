package com.jiuhong.service;


import com.jiuhong.model.JhUserRoleInfo;

/**
 * @Description 用户角色业务处理逻辑层
 * @Author wuxiaoyang
 * @Date 2018/10/15
 */
public interface JhUserRoleService extends BaseService<JhUserRoleInfo> {

    /**
     * 添加用户角色
     *
     * @param jhUserRoleInfo 用户角色信息
     */
    public void addUserRole(JhUserRoleInfo jhUserRoleInfo);
}
