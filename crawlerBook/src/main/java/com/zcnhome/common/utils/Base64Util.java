/**
 * Base64Util.java 2017年2月15日
 * 
 * Copyright 2001-2017 织巢信息 All rights reserved.
 * 织巢信息 PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.zcnhome.common.utils;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * <summary>
 * <description>
 * 
 * @author hqsun
 * @since 2017年2月15日
 * @see [Class/Method]
 *
 */
public class Base64Util {
    /**
     * Base64 加密
     * 
     * @author hqsun
     * @param str
     *            待加密字符串
     * @param count
     *            加密次数
     * @return
     * @since 2017年2月15日
     * @see
     */
    public static String encode(String str, int count) {
        String result = str;
        try {
            for (int i = 0; i < count; i++) {
                result = Base64.getEncoder().encodeToString(result.getBytes("utf-8"));
            }
        }
        catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Base64 解密
     * 
     * @author hqsun
     * @param str
     *            待解密字符串
     * @param count
     *            解密次数
     * @return
     * @since 2017年2月15日
     * @see
     */
    public static String decode(String str, int count) {
        String result = str;
        try {
            for (int i = 0; i < count; i++) {
                result = new String(Base64.getDecoder().decode(result.getBytes()), "utf-8");
            }
        }
        catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }
}
