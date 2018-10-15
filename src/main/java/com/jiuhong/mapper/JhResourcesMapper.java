package com.jiuhong.mapper;


import com.jiuhong.model.JhResourcesInfo;
import com.jiuhong.util.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * @Description 资源查询持久层
 * @Author wuxiaoyang
 * @Date 2018/10/15
 */
public interface JhResourcesMapper extends BaseMapper<JhResourcesInfo> {

    /**
     * 查询所有资源信息
     */
    public List<JhResourcesInfo> queryAll();

    /**
     * 加载用户资源
     *
     * @param map
     */
    public List<JhResourcesInfo> loadUserResources(Map<String, Object> map);

    /**
     * 查询已选中的资源
     *
     * @param rid
     */
    public List<JhResourcesInfo> queryResourcesListWithSelected(Integer rid);
}