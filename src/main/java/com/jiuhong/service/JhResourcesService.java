package com.jiuhong.service;


import com.github.pagehelper.PageInfo;
import com.jiuhong.model.JhResourcesInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by yangqj on 2017/4/25.
 */
public interface JhResourcesService extends BaseService<JhResourcesInfo> {
    PageInfo<JhResourcesInfo> selectByPage(JhResourcesInfo jhResourcesInfo, int start, int length);

    public List<JhResourcesInfo> queryAll();

    public List<JhResourcesInfo> loadUserResources(Map<String, Object> map);

    public List<JhResourcesInfo> queryResourcesListWithSelected(Integer rid);
}
