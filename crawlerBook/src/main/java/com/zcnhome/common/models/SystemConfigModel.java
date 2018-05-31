package com.zcnhome.common.models;

import java.util.Date;

/**
 * Model class of t_system_config
 * 系统配置
 * 
 * @author hqsun
 * @since 2017-8-1
 */
public class SystemConfigModel extends BasicModel {

    /**
     * 配置项id
     */
    private Long id;

    /**
     * 配置项
     */
    private String paramKey;

    /**
     * 配置信息
     */
    private String paramValue;

    /**
     * 描述
     */
    private String description;

    /**
     * 扩展字段
     */
    private String extend;

    /**
     * 修改人id
     */
    private Long modifier;

    /**
     * 修改时间：Y-m-d H:i:S
     */
    private Date modifyTime;

    /**
     * Get the id
     * 
     * @return id
     *         配置项id
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Set the id
     * 
     * @param id
     *            配置项id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get the paramKey
     * 
     * @return paramKey
     *         配置项
     */
    public String getParamKey() {
        return this.paramKey;
    }

    /**
     * Set the paramKey
     * 
     * @param paramKey
     *            配置项
     */
    public void setParamKey(String paramKey) {
        this.paramKey = paramKey;
    }

    /**
     * Get the paramValue
     * 
     * @return paramValue
     *         配置信息
     */
    public String getParamValue() {
        return this.paramValue;
    }

    /**
     * Set the paramValue
     * 
     * @param paramValue
     *            配置信息
     */
    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    /**
     * Get the description
     * 
     * @return description
     *         描述
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Set the description
     * 
     * @param description
     *            描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the extend
     * 
     * @return extend
     *         扩展字段
     */
    public String getExtend() {
        return this.extend;
    }

    /**
     * Set the extend
     * 
     * @param extend
     *            扩展字段
     */
    public void setExtend(String extend) {
        this.extend = extend;
    }

    /**
     * Get the modifier
     * 
     * @return modifier
     *         修改人id
     */
    public Long getModifier() {
        return this.modifier;
    }

    /**
     * Set the modifier
     * 
     * @param modifier
     *            修改人id
     */
    public void setModifier(Long modifier) {
        this.modifier = modifier;
    }

    /**
     * Get the modifyTime
     * 
     * @return modifyTime
     *         修改时间：Y-m-d H:i:S
     */
    public Date getModifyTime() {
        return this.modifyTime;
    }

    /**
     * Set the modifyTime
     * 
     * @param modifyTime
     *            修改时间：Y-m-d H:i:S
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("SystemConfigModel [id=");
        builder.append(id);
        builder.append(", paramKey=");
        builder.append(paramKey);
        builder.append(", paramValue=");
        builder.append(paramValue);
        builder.append(", description=");
        builder.append(description);
        builder.append(", extend=");
        builder.append(extend);
        builder.append(", modifier=");
        builder.append(modifier);
        builder.append(", modifyTime=");
        builder.append(modifyTime);
        builder.append("]");
        return builder.toString();
    }

}
