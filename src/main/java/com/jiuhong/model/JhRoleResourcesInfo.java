package com.jiuhong.model;

import lombok.Data;

import java.io.Serializable;
import javax.persistence.*;

/**
 * @Description 角色资源
 * @Author wuxiaoyang
 * @Date 2018/10/15
 */
@Data
@Table(name = "jh_role_resources")
public class JhRoleResourcesInfo implements Serializable {
    private static final long serialVersionUID = -8559867942708057891L;
    @Id
    @Column(name = "roleId")
    private Integer roleid;

    @Id
    @Column(name = "resourcesId")
    private String resourcesid;

}