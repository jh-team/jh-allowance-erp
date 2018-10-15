package com.jiuhong.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiuhong.mapper.JhRoleMapper;
import com.jiuhong.mapper.JhRoleResourcesMapper;
import com.jiuhong.model.JhRoleInfo;
import com.jiuhong.model.JhRoleResourcesInfo;
import com.jiuhong.service.JhRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service("roleService")
public class JhRoleServiceImpl extends BaseServiceImpl<JhRoleInfo> implements JhRoleService {

    @Resource
    private JhRoleMapper jhRoleMapper;
    @Resource
    private JhRoleResourcesMapper jhRoleResourcesMapper;

    @Override
    public List<JhRoleInfo> queryRoleListWithSelected(Integer uid) {
        return jhRoleMapper.queryRoleListWithSelected(uid);
    }

    @Override
    public PageInfo<JhRoleInfo> selectByPage(JhRoleInfo jhRoleInfo, int start, int length) {
        int page = start/length+1;
        Example example = new Example(JhRoleInfo.class);
        //分页查询
        PageHelper.startPage(page, length);
        List<JhRoleInfo> rolesList = selectByExample(example);
        return new PageInfo<>(rolesList);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor={Exception.class})
    public void delRole(Integer roleid) {
        //删除角色
        mapper.deleteByPrimaryKey(roleid);
        //删除角色资源
        Example example = new Example(JhRoleResourcesInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("roleid",roleid);
        jhRoleResourcesMapper.deleteByExample(example);

    }
}
