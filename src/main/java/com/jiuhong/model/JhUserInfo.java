package com.jiuhong.model;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
*
*@Description 用户信息
*@Author wuxiaoyang
*@Date 2018/10/15
*
*/
@Data
public class JhUserInfo implements Serializable{
    private static final long serialVersionUID = -8736616045315083846L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    private String password;

    /**
     * 是否启用
     */
    private Integer enable;

}