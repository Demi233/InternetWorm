/**
 * MessageMailPojo.java 2017年4月6日
 * 
 * Copyright 2001-2017 织巢信息 All rights reserved.
 * 织巢信息 PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.zcnhome.common.pojo;

/**
 * 邮件消息
 * 
 * @author hqsun
 * @since 2017年4月6日
 */
public class MessageMail {
    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * Get the title
     * 
     * @return title
     * @see MessageMail#title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set the title
     * 
     * @param title
     * @see MessageMail#title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get the content
     * 
     * @return content
     * @see MessageMail#content
     */
    public String getContent() {
        return content;
    }

    /**
     * Set the content
     * 
     * @param content
     * @see MessageMail#content
     */
    public void setContent(String content) {
        this.content = content;
    }
}
