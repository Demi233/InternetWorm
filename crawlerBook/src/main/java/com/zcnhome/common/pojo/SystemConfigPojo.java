/**
 * SystemConfigPojo.java hqsun
 * 
 * Copyright 2001-2016 织巢信息 All rights reserved.
 * 织巢信息 PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.zcnhome.common.pojo;

/**
 * 系统配置模型
 * 
 * @author jnjua
 * @since hqsun
 *
 */
public class SystemConfigPojo {
    /**
     * 邮箱服务器
     */
    private String mailServer;

    /**
     * 用户名
     */
    private String mailUser;

    /**
     * 密码
     */
    private String mailPassword;

    /**
     * 发件人邮箱
     */
    private String mailAddresser;

    /**
     * 邮箱服务器ssl端口
     */
    private String mailSsl;

    /**
     * 域名
     */
    private String domainName;

    /**
     * 系统资源文件存储路径
     */
    private String systemFilesPath;

    /**
     * 用户资源文件存储路径
     */
    private String userFilesPath;

    /**
     * Get the domainName
     * 
     * @return domainName
     * @see SystemConfigPojo#domainName
     */
    public String getDomainName() {
        return domainName;
    }

    /**
     * Set the domainName
     * 
     * @param domainName
     * @see SystemConfigPojo#domainName
     */
    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    /**
     * Get the systemFilesPath
     * 
     * @return systemFilesPath
     * @see SystemConfigPojo#systemFilesPath
     */
    public String getSystemFilesPath() {
        return systemFilesPath;
    }

    /**
     * Set the systemFilesPath
     * 
     * @param systemFilesPath
     * @see SystemConfigPojo#systemFilesPath
     */
    public void setSystemFilesPath(String systemFilesPath) {
        this.systemFilesPath = systemFilesPath;
    }

    /**
     * Get the userFilesPath
     * 
     * @return userFilesPath
     * @see SystemConfigPojo#userFilesPath
     */
    public String getUserFilesPath() {
        return userFilesPath;
    }

    /**
     * Set the userFilesPath
     * 
     * @param userFilesPath
     * @see SystemConfigPojo#userFilesPath
     */
    public void setUserFilesPath(String userFilesPath) {
        this.userFilesPath = userFilesPath;
    }

    /**
     * @return the mailServer
     * @see SystemConfigPojo#mailServer
     */
    public String getMailServer() {
        return mailServer;
    }

    /**
     * @param mailServer
     *            the mailServer to set
     * @see SystemConfigPojo#mailServer
     */
    public void setMailServer(String mailServer) {
        this.mailServer = mailServer;
    }

    /**
     * @return the mailUser
     * @see SystemConfigPojo#mailUser
     */
    public String getMailUser() {
        return mailUser;
    }

    /**
     * @param mailUser
     *            the mailUser to set
     * @see SystemConfigPojo#mailUser
     */
    public void setMailUser(String mailUser) {
        this.mailUser = mailUser;
    }

    /**
     * @return the mailPassword
     * @see SystemConfigPojo#mailPassword
     */
    public String getMailPassword() {
        return mailPassword;
    }

    /**
     * @param mailPassword
     *            the mailPassword to set
     * @see SystemConfigPojo#mailPassword
     */
    public void setMailPassword(String mailPassword) {
        this.mailPassword = mailPassword;
    }

    /**
     * @return the mailAddresser
     * @see SystemConfigPojo#mailAddresser
     */
    public String getMailAddresser() {
        return mailAddresser;
    }

    /**
     * @param mailAddresser
     *            the mailAddresser to set
     * @see SystemConfigPojo#mailAddresser
     */
    public void setMailAddresser(String mailAddresser) {
        this.mailAddresser = mailAddresser;
    }

    /**
     * @return the mailSsl
     * @see SystemConfigPojo#mailSsl
     */
    public String getMailSsl() {
        return mailSsl;
    }

    /**
     * @param mailSsl
     *            the mailSsl to set
     * @see SystemConfigPojo#mailSsl
     */
    public void setMailSsl(String mailSsl) {
        this.mailSsl = mailSsl;
    }

}
