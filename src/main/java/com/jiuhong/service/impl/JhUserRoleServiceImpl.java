package com.jiuhong.service.impl;

import com.jiuhong.model.JhUserRoleInfo;
import com.jiuhong.service.JhUserRoleService;
import com.jiuhong.shiro.MyShiroRealm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangqj on 2017/4/26.
 */
@Service("userRoleService")
public class JhUserRoleServiceImpl extends BaseServiceImpl<JhUserRoleInfo> implements JhUserRoleService {
    @Autowired
    private MyShiroRealm myShiroRealm;

    @Override
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor={Exception.class})
    public void addUserRole(JhUserRoleInfo jhUserRoleInfo) {
        //删除
        Example example = new Example(JhUserRoleInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userid", jhUserRoleInfo.getUserid());
        mapper.deleteByExample(example);
        //添加
        String[] roleids = jhUserRoleInfo.getRoleid().split(",");
        for (String roleId : roleids) {
            JhUserRoleInfo u = new JhUserRoleInfo();
            u.setUserid(jhUserRoleInfo.getUserid());
            u.setRoleid(roleId);
            mapper.insert(u);
        }
        //更新当前登录的用户的权限缓存
        List<Integer> userid = new ArrayList<Integer>();
        userid.add(jhUserRoleInfo.getUserid());
        myShiroRealm.clearUserAuthByUserId(userid);
    }
}
