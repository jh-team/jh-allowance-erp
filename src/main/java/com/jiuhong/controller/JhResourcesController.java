package com.jiuhong.controller;


import com.github.pagehelper.PageInfo;
import com.jiuhong.model.JhResourcesInfo;
import com.jiuhong.service.JhResourcesService;
import com.jiuhong.shiro.ShiroService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description 资源配置处理类
 * @Author wuxiaoyang
 * @Date 2018/10/15
 */
@RestController
@RequestMapping("/resources")
@Slf4j
public class JhResourcesController {

    @Resource
    private JhResourcesService resourcesService;
    @Resource
    private ShiroService shiroService;

    @RequestMapping
    public Map<String, Object> getAll(JhResourcesInfo jhResourcesInfo, String draw,
                                      @RequestParam(required = false, defaultValue = "1") int start,
                                      @RequestParam(required = false, defaultValue = "10") int length) {
        Map<String, Object> map = new HashMap<>();
        PageInfo<JhResourcesInfo> pageInfo = resourcesService.selectByPage(jhResourcesInfo, start, length);
        log.info("pageInfo.getTotal():" + pageInfo.getTotal());
        map.put("draw", draw);
        map.put("recordsTotal", pageInfo.getTotal());
        map.put("recordsFiltered", pageInfo.getTotal());
        map.put("data", pageInfo.getList());
        return map;
    }

    /**
     * 查询选中的资源
     *
     * @param rid
     */
    @RequestMapping("/resourcesWithSelected")
    public List<JhResourcesInfo> resourcesWithSelected(Integer rid) {
        return resourcesService.queryResourcesListWithSelected(rid);
    }

    /**
     * 加载菜单
     *
     * @return
     */
    @RequestMapping("/loadMenu")
    public List<JhResourcesInfo> loadMenu() {
        Map<String, Object> map = new HashMap<>();
        Integer userid = (Integer) SecurityUtils.getSubject().getSession().getAttribute("userSessionId");
        map.put("type", 1);
        map.put("userid", userid);
        List<JhResourcesInfo> jhResourcesInfoList = resourcesService.loadUserResources(map);
        return jhResourcesInfoList;
    }

    /**
     * 添加资源
     *
     * @param jhResourcesInfo 资源信息
     */
    @RequestMapping(value = "/add")
    public String add(JhResourcesInfo jhResourcesInfo) {
        try {
            resourcesService.save(jhResourcesInfo);
            //更新权限
            shiroService.updatePermission();
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    /**
     * 删除资源
     *
     * @param id id
     */
    @RequestMapping(value = "/delete")
    public String delete(Integer id) {
        try {
            resourcesService.delete(id);
            //更新权限
            shiroService.updatePermission();
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }
}
