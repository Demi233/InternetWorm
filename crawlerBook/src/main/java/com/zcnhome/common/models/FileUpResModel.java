/**
 * FileUploadModel.java 2017-8-1
 * 
 * Copyright 2001-2016 织巢信息 All rights reserved.
 * 织巢信息 PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.zcnhome.common.models;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 文件上传返回信息
 * 
 * @author hqsun
 * @since 2017-8-1
 *
 */
public class FileUpResModel extends BasicModel {

    /**
     * 文件获取地址
     */
    private String access;

    /**
     * 文件后缀名
     */
    private String extName;

    /**
     * Get the access
     * 
     * @return access
     * @see FileUpResModel#access
     */
    public String getAccess() {
        return access;
    }

    /**
     * Set the access
     * 
     * @param access
     * @see FileUpResModel#access
     */
    public void setAccess(String access) {
        this.access = access;
    }

    /**
     * @return the extName
     * @see FileUpResModel#extName
     */
    public String getExtName() {
        return extName;
    }

    /**
     * @param extName
     *            the extName to set
     * @see FileUpResModel#extName
     */
    public void setExtName(String extName) {
        this.extName = extName;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
