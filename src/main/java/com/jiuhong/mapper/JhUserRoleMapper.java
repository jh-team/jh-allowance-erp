package com.jiuhong.mapper;


import com.jiuhong.model.JhUserRoleInfo;
import com.jiuhong.util.BaseMapper;

import java.util.List;

public interface JhUserRoleMapper extends BaseMapper<JhUserRoleInfo> {
    public List<Integer> findUserIdByRoleId(Integer roleId);
}