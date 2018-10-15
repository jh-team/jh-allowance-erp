package com.jiuhong.service;


import com.github.pagehelper.PageInfo;
import com.jiuhong.model.JhResourcesInfo;

import java.util.List;
import java.util.Map;

/**
 * @Description 资源业务处理逻辑层
 * @Author wuxiaoyang
 * @Date 2018/10/15
 */
public interface JhResourcesService extends BaseService<JhResourcesInfo> {
    /**
     * 分页查询
     * @param jhResourcesInfo
     * @param start
     * @param length
     * @return
     */
    PageInfo<JhResourcesInfo> selectByPage(JhResourcesInfo jhResourcesInfo, int start, int length);

    /**
     * 查询所有资源信息
     * @return
     */
    public List<JhResourcesInfo> queryAll();

    /**
     * 加载用户资源
     * @param map
     * @return
     */
    public List<JhResourcesInfo> loadUserResources(Map<String, Object> map);

    /**
     * 查询已选中的资源
     * @param rid
     * @return
     */
    public List<JhResourcesInfo> queryResourcesListWithSelected(Integer rid);
}
