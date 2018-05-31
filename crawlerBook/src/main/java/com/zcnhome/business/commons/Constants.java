/**
 * Constants.java 2017-8-1
 * 
 * Copyright 2001-2016 织巢信息 All rights reserved.
 * 织巢信息 PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.zcnhome.business.commons;

/**
 * 业务常量表
 * 
 * @author hqsun
 * @since 2017-8-1
 *
 */
public final class Constants {
    public static final class Commons {

        /**
         * UTF-8 中文字符
         */
        public static final String CHARACTER_SET = "UTF-8";
        
        /**
         * 刀勒符号
         */
        public static final String DOLLAR = "$";


        /**
         * 前台用户SESSION key键
         */
        public final static String SESSION_WEB_USER = "webUser";
        
        /**
         * 后台用户SESSION key键
         */
        public final static String SESSION_STORE_USER = "storeUser";
        
        /**
         * 进行密码修改操作的用户SESSION key键
         */
        public final static String SESSION_FORGOT_USER = "forgotUser";

        /**
         * 未读消息SESSION key键
         */
        public final static String MESSAGE_COUNT = "mCount";

        
        /**
         * Email链接有效时间
         */
        public static final Integer EFFECTIVE_TIME = 86400;
        
        /**
         * 短信对象
         */
        public static final String SMS_VERIFY = "smsVerify";
        
        /**
         * 是否验证通过
         */
        public static final  String IS_SMS_VERIFY = "isSmsVerify";
        
        /**
         * 短信有效时间（毫秒）
         */
        public static final int SMS_EFFECTIVE_TIME = 600000;
        
        /**
         * 短信重试时间（毫秒）
         */
        public static final int SMS_RESEND_TIME = 60000;
        
        /**
         * 同个Session 1个小时内最多发送次数
         */
        public static final int SMS_HOUR_CNT=10;

        /**
         * 登录验证码
         */
        public static final String VERIFY_CODE = "verifyCode";
        
        
        /**
         * 注册验证码
         */
        public static final String REGISTER_VERIFY_CODE = "registerVerifyCode";

        /**
         * 忘记密码验证码
         */
        public static final String UPDATE_PWD_VERIFY_CODE = "updatePwdVerifyCode";
        
        
        /**
         * 留言验证码
         */
        public static final String MSG_VERIFY_CODE = "msgVerifyCode";

    }

    /**
     * 系统配置项目
     * 
     * @author hqsun
     * @since 2017年1月4日
     *
     */
    public static final class SystemConfig {

        /**
         * 系统资源文件存储路径
         */
        public static final String SYSTEM_FILES_PATH = "system.files.path";

        /**
         * 用户资源文件存储路径
         */
        public static final String USER_FILES_PATH = "user.files.path";

        /**
         * 域名
         */
        public static final String DOMAIN_NAME = "domain.name";

        /**
         * 教学资源包下载告警阈值（单位：次）
         */
        public static final String PREP_DOWNLOAD_WARNING = "prep.download.warning";

        /**
         * 教学资源包订购有效期（单位：月）
         */
        public static final String PREP_ORDER_PERIOD = "prep.order.period";

        /**
         * 邮箱服务器
         */
        public static final String MAIL_SERVER = "mail.server";

        /**
         * 用户名
         */
        public static final String MAIL_USER = "mail.user";

        /**
         * 密码
         */
        public static final String MAIL_PASSWORD = "mail.password";

        /**
         * 发件人邮箱
         */
        public static final String MAIL_ADDRESSER = "mail.addresser";

        /**
         * 邮箱服务器ssl端口
         */
        public static final String MAIL_SSL = "mail.ssl";

    }
    
    
    /**
     * 类型常量表
     */
    public interface FileType {
        /**
         * 用户头像
         */
        int USER_ICON = 1;

        
        /**
         * 轮播图
         */
        int BANNER_IMAGE = 7;

        /**
         * 最新资讯图片
         */
        int NEWS_IMAGE = 9;


        /**
         * 友情链接图片
         */
        int FRIENDLY_URL_IMAGE = 11;

        /**
         * 二维码图片
         */
        int QR_IMAGE = 12;

        
        /**
         * 宣传视频
         */
        int PROPAGANDA_VIDEO = 16;
    }
}
