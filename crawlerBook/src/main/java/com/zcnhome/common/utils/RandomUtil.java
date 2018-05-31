/**
 * RandomUtil.java 2017年2月13日
 * 
 * Copyright 2001-2017 织巢信息 All rights reserved.
 * 织巢信息 PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.zcnhome.common.utils;

import java.util.Random;

/**
 * 随机数工具
 * 
 * @author hqsun
 * @since 2017年2月13日
 *
 */
public class RandomUtil {

    /**
     * 获取不重复的随机数数组
     *
     * @author hqsun
     * @param max
     *            最大值（不包含）
     * @param len
     *            数组长度
     * @return
     * @since 2017年2月13日
     */
    public static int[] intArr(int max, int len) {
        return intArr(0, max, len);
    }

    /**
     * 获取不重复的随机数数组
     * max-min>=len
     *
     * @author hqsun
     * @param min
     *            最小值（包含）
     * @param max
     *            最大值（不包含）
     * @param len
     *            数组长度（len<=max-min）
     * @return
     * @since 2017年2月13日
     */
    public static int[] intArr(int min, int max, int len) {

        int[] arr = new int[len];
        if (max - min >= len) {
            Random random = new Random();

            int n = 0;
            boolean b = true;

            for (int i = 0; i < len; i++) {
                b = true;
                while (b) {
                    b = false;
                    n = random.nextInt(max);

                    if (n >= min) {
                        for (int j = 0; j < i; j++) {
                            if (n == arr[j]) {
                                b = true;
                                break;
                            }
                        }
                    }
                    else {
                        b = true;
                    }

                    if (!b) {
                        arr[i] = n;
                    }
                }
            }
        }

        return arr;
    }

    /**
     * 私有构造
     */
    private RandomUtil() {
    }
    
    
    public static void main(String[] args) {
        
    }
}
