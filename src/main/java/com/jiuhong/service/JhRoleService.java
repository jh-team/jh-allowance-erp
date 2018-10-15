package com.jiuhong.service;


import com.github.pagehelper.PageInfo;
import com.jiuhong.model.JhRoleInfo;

import java.util.List;

/**
 * @Description 角色业务处理逻辑层
 * @Author wuxiaoyang
 * @Date 2018/10/15
 */
public interface JhRoleService extends BaseService<JhRoleInfo> {

    public List<JhRoleInfo> queryRoleListWithSelected(Integer uid);

    PageInfo<JhRoleInfo> selectByPage(JhRoleInfo jhRoleInfo, int start, int length);

    /**
     * 删除角色 同时删除角色资源表中的数据
     * @param roleid
     */
    public void delRole(Integer roleid);
}
