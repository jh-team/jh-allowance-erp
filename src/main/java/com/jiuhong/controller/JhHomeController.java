package com.jiuhong.controller;

import com.jiuhong.model.JhUserInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description 主模块处理类
 * @Author wuxiaoyang
 * @Date 2018/10/15
 */
@Controller
public class JhHomeController {

    /**
     * 登录页面
     *
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    /**
     * 处理用户登录请求
     *
     * @param request    请求参数
     * @param jhUserInfo 用户信息
     * @param model      模型层
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, JhUserInfo jhUserInfo, Model model) {
        if (StringUtils.isEmpty(jhUserInfo.getUsername()) || StringUtils.isEmpty(jhUserInfo.getPassword())) {
            request.setAttribute("msg", "用户名或密码不能为空！");
            return "login";
        }
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(jhUserInfo.getUsername(), jhUserInfo.getPassword());
        try {
            subject.login(token);
            return "redirect:usersPage";
        } catch (LockedAccountException lae) {
            token.clear();
            request.setAttribute("msg", "用户已经被锁定不能登录，请与管理员联系！");
            return "login";
        } catch (AuthenticationException e) {
            token.clear();
            request.setAttribute("msg", "用户或密码不正确！");
            return "login";
        }
    }

    /**
     * 用户管理页
     */
    @RequestMapping(value = {"/usersPage", ""})
    public String usersPage() {
        return "user/users";
    }

    /**
     * 角色管理页
     */
    @RequestMapping("/rolesPage")
    public String rolesPage() {
        return "role/roles";
    }

    /**
     * 资源模块页
     */
    @RequestMapping("/resourcesPage")
    public String resourcesPage() {
        return "resources/resources";
    }

    /**
     * 未授权跳转页
     */
    @RequestMapping("/403")
    public String forbidden() {
        return "403";
    }
}
