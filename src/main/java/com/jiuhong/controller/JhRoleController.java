package com.jiuhong.controller;


import com.github.pagehelper.PageInfo;
import com.jiuhong.model.JhRoleInfo;
import com.jiuhong.model.JhRoleResourcesInfo;
import com.jiuhong.service.JhRoleResourcesService;
import com.jiuhong.service.JhRoleService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description 角色处理类
 * @Author wuxiaoyang
 * @Date 2018/10/15
 */
@RestController
@RequestMapping("/roles")
public class JhRoleController {
    @Resource
    private JhRoleService jhRoleService;
    @Resource
    private JhRoleResourcesService jhRoleResourcesService;

    @RequestMapping
    public Map<String, Object> getAll(JhRoleInfo jhRoleInfo, String draw,
                                      @RequestParam(required = false, defaultValue = "1") int start,
                                      @RequestParam(required = false, defaultValue = "10") int length) {

        Map<String, Object> map = new HashMap<>();
        PageInfo<JhRoleInfo> pageInfo = jhRoleService.selectByPage(jhRoleInfo, start, length);
        map.put("draw", draw);
        map.put("recordsTotal", pageInfo.getTotal());
        map.put("recordsFiltered", pageInfo.getTotal());
        map.put("data", pageInfo.getList());
        return map;
    }

    @RequestMapping("/rolesWithSelected")
    public List<JhRoleInfo> rolesWithSelected(Integer uid) {
        return jhRoleService.queryRoleListWithSelected(uid);
    }


    /**
     * 分配角色
     *
     * @param jhRoleResourcesInfo 角色资源信息
     */
    @RequestMapping("/saveRoleResources")
    public String saveRoleResources(JhRoleResourcesInfo jhRoleResourcesInfo) {
        if (StringUtils.isEmpty(jhRoleResourcesInfo.getRoleid()))
            return "error";
        try {
            jhRoleResourcesService.addRoleResources(jhRoleResourcesInfo);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping(value = "/add")
    public String add(JhRoleInfo jhRoleInfo) {
        try {
            jhRoleService.save(jhRoleInfo);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping(value = "/delete")
    public String delete(Integer id) {
        try {
            jhRoleService.delRole(id);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }


}
