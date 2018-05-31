/**
 * SystemConfigMapper.java 2017年08月01日
 * 
 * Copyright 2001-2016 织巢信息 All rights reserved.
 * 织巢信息 PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.zcnhome.common.dao;

import java.util.List;

import com.zcnhome.common.models.SystemConfigModel;

/**
 * SystemConfig Mapper
 * 
 * @author hqsun
 * @since 2017年08月01日
 *
 */
public interface SystemConfigMapper {
    /**
     * 查询系统配置列表信息
     *
     * @author hqsun
     * @param systemConfigModel 系统配置模型
     * @return 系统配置列表
     * @since 2017年08月01日
     */
    public List<SystemConfigModel> getList();

    /**
     * 更新系统配置
     *
     * @author hqsun
     * @param systemConfigModel 系统配置模型
     * @return 持久化操作返回码
     * @since 2017年08月01日
     */
    public int update(SystemConfigModel systemConfigModel);

    /**
     * 查询系统配置
     *
     * @author hqsun
     * @param systemConfigModel 系统配置模型
     * @return 持久化操作返回码
     * @since 2017-8-1
     */
    public String get(String string);

}
