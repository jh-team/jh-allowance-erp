package com.jiuhong.util;

/**
 * 特别注意，该接口不能被扫描到，否则会出错
 *
 * @Description
 * @Author wuxiaoyang
 * @Date 2018/10/15
 */

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {
}

