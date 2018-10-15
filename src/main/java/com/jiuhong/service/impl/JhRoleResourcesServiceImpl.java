package com.jiuhong.service.impl;

import com.jiuhong.mapper.JhUserRoleMapper;
import com.jiuhong.model.JhRoleResourcesInfo;
import com.jiuhong.service.JhRoleResourcesService;
import com.jiuhong.shiro.MyShiroRealm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service("roleResourcesService")
public class JhRoleResourcesServiceImpl extends BaseServiceImpl<JhRoleResourcesInfo> implements JhRoleResourcesService {
    @Resource
    private JhUserRoleMapper jhUserRoleMapper;
    /*@Resource
    private ShiroService shiroService;*/
    @Autowired
    private MyShiroRealm myShiroRealm;

    @Override
    //更新权限
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor={Exception.class})
    //@CacheEvict(cacheNames="resources", allEntries=true)
    public void addRoleResources(JhRoleResourcesInfo jhRoleResourcesInfo) {
        //删除
        Example example = new Example(JhRoleResourcesInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("roleid", jhRoleResourcesInfo.getRoleid());
        mapper.deleteByExample(example);
        //添加
        if(!StringUtils.isEmpty(jhRoleResourcesInfo.getResourcesid())){
            String[] resourcesArr = jhRoleResourcesInfo.getResourcesid().split(",");
            for(String resourcesId:resourcesArr ){
                JhRoleResourcesInfo r = new JhRoleResourcesInfo();
                r.setRoleid(jhRoleResourcesInfo.getRoleid());
                r.setResourcesid(resourcesId);
                mapper.insert(r);
            }
        }

        List<Integer> userIds= jhUserRoleMapper.findUserIdByRoleId(jhRoleResourcesInfo.getRoleid());
        //更新当前登录的用户的权限缓存
        myShiroRealm.clearUserAuthByUserId(userIds);


    }
}
