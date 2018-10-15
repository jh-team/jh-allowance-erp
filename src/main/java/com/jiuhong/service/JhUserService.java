package com.jiuhong.service;

import com.github.pagehelper.PageInfo;
import com.jiuhong.model.JhUserInfo;

/**
 * Created by yangqj on 2017/4/21.
 */
public interface JhUserService extends BaseService<JhUserInfo>{
    PageInfo<JhUserInfo> selectByPage(JhUserInfo jhUserInfo, int start, int length);

    JhUserInfo selectByUsername(String username);

    void delUser(Integer userid);

}
