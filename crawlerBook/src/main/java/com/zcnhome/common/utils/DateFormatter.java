/**
 * DateFormatter.java 2017-8-1
 * 
 * Copyright 2001-2016 织巢信息 All rights reserved.
 * 织巢信息 PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.zcnhome.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

/**
 * 日期格式化
 * 
 * @author hqsun
 * @since 2017-8-1
 *
 */
public final class DateFormatter {

    /**
     * 将日期格式化字符串
     *
     * @author hqsun
     * @param format
     * @param date
     * @return
     * @since 2017-8-1
     */
    public static String formatDate(String format, Date date) {
        SimpleDateFormat sdf = null;

        if (StringUtils.isNotBlank(format)) {
            sdf = new SimpleDateFormat(format);
        }
        else {
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        }

        if (null == date) {
            return sdf.format(new Date());
        }

        return sdf.format(date);
    }

    /**
     * 将系统当前时间格式化字符串
     *
     * @author hqsun
     * @param format
     * @return
     * @since 2017-8-1
     */
    public static String formatDate(String format) {
        return formatDate(format, new Date());
    }

    /**
     * 将时间戳格式化字符串
     *
     * @author hqsun
     * @param format
     * @param timestamp
     * @return
     * @since 2017-8-1
     */
    public static String formatDate(String format, long timestamp) {
        if (timestamp > 0) {
            return formatDate(format, new Date(timestamp));
        }
        return formatDate(format, new Date());
    }

    /**
     * 将字符串转化为日期
     *
     * @author hqsun
     * @param format
     * @param str
     * @return
     * @since 2016年11月21日
     */
    public static Date toDate(String format, String str) {
        SimpleDateFormat sdf = null;

        if (StringUtils.isNotBlank(format)) {
            sdf = new SimpleDateFormat(format);
        }
        else {
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        }

        Date date = null;
        if (StringUtils.isNotBlank(str)) {
            try {
                date = sdf.parse(str);
            }
            catch (ParseException e) {
            }
        }

        return date;
    }

    /**
     * 私有构造
     */
    private DateFormatter() {
    }
}
