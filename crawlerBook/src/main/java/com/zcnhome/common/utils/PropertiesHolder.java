/**
 * PropertiesHolder.java 2017-8-1
 * 
 * Copyright 2001-2016 织巢信息 All rights reserved.
 * 织巢信息 PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.zcnhome.common.utils;

import java.util.Map.Entry;
import java.util.Properties;

import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * 配置文件properties加载器
 * 
 * @author hqsun
 * @since 2017-8-1
 *
 */
public class PropertiesHolder extends PropertyPlaceholderConfigurer {

    /**
     * logger
     */
    private Log logger = LogFactory.getLog(PropertiesHolder.class);

    /**
     * 键值对配置信息
     */
    private Properties config = new Properties();

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.beans.factory.config.PropertyPlaceholderConfigurer#
     * processProperties(org.springframework.beans.factory.config.
     * ConfigurableListableBeanFactory, java.util.Properties)
     */
    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props)
            throws BeansException {

        super.processProperties(beanFactoryToProcess, props);

        logger.trace("System start loaded configurations.");

        if (MapUtils.isNotEmpty(props)) {

            Object key = null;
            Object value = null;

            for (Entry<Object, Object> e : props.entrySet()) {
                key = e.getKey();
                value = e.getValue();

                config.put(key, value);

                logger.trace("config loaded. " + String.valueOf(key) + " = " + String.valueOf(value));
            }
        }

    }

    /**
     * 根据key获取字符串类型value
     *
     * @author hqsun
     * @param key
     * @return
     * @since 2017-8-1
     */
    public String get(String key) {
        return get(key, "");
    }

    /**
     * 根据key获取字符串类型value
     *
     * @author hqsun
     * @param key
     * @param def
     * @return
     * @since 2017-8-1
     */
    public String get(String key, String def) {
        return config.getProperty(key, def);
    }

    /**
     * 根据key获取int类型value
     *
     * @author hqsun
     * @param key
     * @param def
     * @return
     * @since 2017-8-1
     */
    public int integer(String key, int def) {
        return NumberUtils.toInt(config.getProperty(key), def);
    }

    /**
     * 根据key获取long类型value
     *
     * @author hqsun
     * @param key
     * @param def
     * @return
     * @since 2017-8-1
     */
    public long bigInteger(String key, long def) {
        return NumberUtils.toLong(config.getProperty(key), def);
    }

}
