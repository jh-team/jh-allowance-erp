package com.jiuhong.service;


import com.jiuhong.model.JhRoleResourcesInfo;

/**
 * @Description 角色资源业务处理逻辑层
 * @Author wuxiaoyang
 * @Date 2018/10/15
 */
public interface JhRoleResourcesService extends BaseService<JhRoleResourcesInfo> {

    public void addRoleResources(JhRoleResourcesInfo jhRoleResourcesInfo);
}
