package com.jiuhong.service;


import com.jiuhong.model.JhUserRoleInfo;

/**
 * Created by yangqj on 2017/4/26.
 */
public interface JhUserRoleService extends BaseService<JhUserRoleInfo> {

    public void addUserRole(JhUserRoleInfo jhUserRoleInfo);
}
