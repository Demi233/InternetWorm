package com.zcnhome.business.models;

import java.util.Date;

import com.zcnhome.common.models.BasicModel;

/**
 * Model class of t_login_records
 * 用户登录信息表
 * 
 * @author hqsun
 * @since 2017-8-1
 */
public class LoginRecordsModel extends BasicModel {

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户最近登录时间：Y-m-d H:i:S
     */
    private Date loginTime;

    /**
     * 客户端ip
     */
    private String clientIp;

    /**
     * 设备类型：1，IE；2，Chrome；3，FireFox；4，Safari；5，Edge；6，Other
     */
    private Integer device;

    /**
     * Get the userId
     * 
     * @return userId
     *         用户id
     */
    public Long getUserId() {
        return this.userId;
    }

    /**
     * Set the userId
     * 
     * @param userId
     *            用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * Get the loginTime
     * 
     * @return loginTime
     *         用户最近登录时间：Y-m-d H:i:S
     */
    public Date getLoginTime() {
        return this.loginTime;
    }

    /**
     * Set the loginTime
     * 
     * @param loginTime
     *            用户最近登录时间：Y-m-d H:i:S
     */
    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    /**
     * Get the clientIp
     * 
     * @return clientIp
     *         客户端ip
     */
    public String getClientIp() {
        return this.clientIp;
    }

    /**
     * Set the clientIp
     * 
     * @param clientIp
     *            客户端ip
     */
    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    /**
     * Get the device
     * 
     * @return device
     *         设备类型：1，IE；2，Chrome；3，FireFox；4，Safari；5，Edge；6，Other
     */
    public Integer getDevice() {
        return this.device;
    }

    /**
     * Set the device
     * 
     * @param device
     *            设备类型：1，IE；2，Chrome；3，FireFox；4，Safari；5，Edge；6，Other
     */
    public void setDevice(Integer device) {
        this.device = device;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("LoginRecordsModel [user_id=");
        builder.append(userId);
        builder.append(", loginTime=");
        builder.append(loginTime);
        builder.append(", clientIp=");
        builder.append(clientIp);
        builder.append(", device=");
        builder.append(device);
        builder.append("]");
        return builder.toString();
    }

}
