package com.jiuhong.mapper;


import com.jiuhong.model.JhRoleInfo;
import com.jiuhong.util.BaseMapper;

import java.util.List;

/**
 * @Description 角色持久层
 * @Author wuxiaoyang
 * @Date 2018/10/15
 */
public interface JhRoleMapper extends BaseMapper<JhRoleInfo> {

    public List<JhRoleInfo> queryRoleListWithSelected(Integer id);
}