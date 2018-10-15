package com.jiuhong.model;

import lombok.Data;

import java.io.Serializable;
import javax.persistence.*;

/**
 * @Description 用户角色
 * @Author wuxiaoyang
 * @Date 2018/10/15
 */
@Data
@Table(name = "jh_user_role")
public class JhUserRoleInfo implements Serializable {
    private static final long serialVersionUID = -916411139749530670L;
    @Column(name = "userId")
    private Integer userid;

    @Column(name = "roleId")
    private String roleid;

}