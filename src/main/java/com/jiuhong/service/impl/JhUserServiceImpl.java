package com.jiuhong.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiuhong.mapper.JhUserRoleMapper;
import com.jiuhong.model.JhUserInfo;
import com.jiuhong.model.JhUserRoleInfo;
import com.jiuhong.service.JhUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class JhUserServiceImpl extends BaseServiceImpl<JhUserInfo> implements JhUserService {
    @Resource
    private JhUserRoleMapper jhUserRoleMapper;

    @Override
    public PageInfo<JhUserInfo> selectByPage(JhUserInfo jhUserInfo, int start, int length) {
        int page = start / length + 1;
        Example example = new Example(JhUserInfo.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtil.isNotEmpty(jhUserInfo.getUsername())) {
            criteria.andLike("username", "%" + jhUserInfo.getUsername() + "%");
        }
        if (jhUserInfo.getId() != null) {
            criteria.andEqualTo("id", jhUserInfo.getId());

        }
        if (jhUserInfo.getEnable() != null) {
            criteria.andEqualTo("enable", jhUserInfo.getEnable());
        }
        //分页查询
        PageHelper.startPage(page, length);
        List<JhUserInfo> jhUserInfoList = selectByExample(example);
        return new PageInfo<>(jhUserInfoList);
    }

    @Override
    public JhUserInfo selectByUsername(String username) {
        Example example = new Example(JhUserInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username", username);
        List<JhUserInfo> jhUserInfoList = selectByExample(example);
        if (jhUserInfoList.size() > 0) {
            return jhUserInfoList.get(0);
        }
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = {Exception.class})
    public void delUser(Integer userid) {
        //删除用户表
        mapper.deleteByPrimaryKey(userid);
        //删除用户角色表
        Example example = new Example(JhUserRoleInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userid", userid);
        jhUserRoleMapper.deleteByExample(example);
    }

    @Override
    public JhUserInfo selectById(Integer id) {
        Example example = new Example(JhUserInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", id);
        List<JhUserInfo> jhUserInfoList = selectByExample(example);
        if (jhUserInfoList.size() > 0) {
            return jhUserInfoList.get(0);
        }
        return null;
    }

}
