package com.jiuhong.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiuhong.mapper.JhResourcesMapper;
import com.jiuhong.model.JhResourcesInfo;
import com.jiuhong.service.JhResourcesService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("resourcesService")
public class JhResourcesServiceImpl extends BaseServiceImpl<JhResourcesInfo> implements JhResourcesService {
   @Resource
    private JhResourcesMapper jhResourcesMapper;

    @Override
    public PageInfo<JhResourcesInfo> selectByPage(JhResourcesInfo jhResourcesInfo, int start, int length) {
        int page = start/length+1;
        Example example = new Example(JhResourcesInfo.class);
        //分页查询
        PageHelper.startPage(page, length);
        List<JhResourcesInfo> userList = selectByExample(example);
        return new PageInfo<>(userList);
    }

    @Override
    public List<JhResourcesInfo> queryAll(){
        return jhResourcesMapper.queryAll();
    }

    @Override
    //@Cacheable(cacheNames="resources",key="#map['userid'].toString()+#map['type']")
    public List<JhResourcesInfo> loadUserResources(Map<String, Object> map) {
        return jhResourcesMapper.loadUserResources(map);
    }

    @Override
    public List<JhResourcesInfo> queryResourcesListWithSelected(Integer rid) {
        return jhResourcesMapper.queryResourcesListWithSelected(rid);
    }
}
