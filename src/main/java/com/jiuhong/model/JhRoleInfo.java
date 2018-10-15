package com.jiuhong.model;

import lombok.Data;

import java.io.Serializable;
import javax.persistence.*;

/**
 * @Description 角色信息
 * @Author wuxiaoyang
 * @Date 2018/10/15
 */
@Data
public class JhRoleInfo implements Serializable {
    private static final long serialVersionUID = -6140090613812307452L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "roleDesc")
    private String roledesc;
    @Transient
    private Integer selected;
}