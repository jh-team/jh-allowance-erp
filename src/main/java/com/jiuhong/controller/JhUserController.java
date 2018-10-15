package com.jiuhong.controller;

import com.github.pagehelper.PageInfo;
import com.jiuhong.model.JhUserInfo;
import com.jiuhong.model.JhUserRoleInfo;
import com.jiuhong.service.JhUserRoleService;
import com.jiuhong.service.JhUserService;
import com.jiuhong.util.PasswordHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description 用户
 * @Author wuxiaoyang
 * @Date 2018/10/15
 */
@RestController
@RequestMapping("/users")
@Slf4j
public class JhUserController {
    @Resource
    private JhUserService jhUserService;
    @Resource
    private JhUserRoleService jhUserRoleService;

    /**
     * 获取用户列表
     *
     * @param jhUserInfo
     * @param draw
     * @param start
     * @param length
     * @return
     */
    @RequestMapping
    public Map<String, Object> getAll(JhUserInfo jhUserInfo, String draw,
                                      @RequestParam(required = false, defaultValue = "1") int start,
                                      @RequestParam(required = false, defaultValue = "10") int length) {
        Map<String, Object> map = new HashMap<>();
        PageInfo<JhUserInfo> pageInfo = jhUserService.selectByPage(jhUserInfo, start, length);
        log.info("pageInfo.getTotal():" + pageInfo.getTotal());
        map.put("draw", draw);
        map.put("recordsTotal", pageInfo.getTotal());
        map.put("recordsFiltered", pageInfo.getTotal());
        map.put("data", pageInfo.getList());
        return map;
    }


    /**
     * 保存用户角色
     *
     * @param jhUserRoleInfo 用户角色
     *                       此处获取的参数的角色id是以 “,” 分隔的字符串
     * @return
     */
    @RequestMapping("/saveUserRoles")
    public String saveUserRoles(JhUserRoleInfo jhUserRoleInfo) {
        if (StringUtils.isEmpty(jhUserRoleInfo.getUserid()))
            return "error";
        try {
            jhUserRoleService.addUserRole(jhUserRoleInfo);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping(value = "/add")
    public String add(JhUserInfo jhUserInfo) {
        JhUserInfo u = jhUserService.selectByUsername(jhUserInfo.getUsername());
        if (u != null)
            return "error";
        try {
            jhUserInfo.setEnable(1);
            PasswordHelper passwordHelper = new PasswordHelper();
            passwordHelper.encryptPassword(jhUserInfo);
            jhUserService.save(jhUserInfo);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping(value = "/delete")
    public String delete(Integer id) {
        try {
            jhUserService.delUser(id);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

}
