/**
 * Page.java 2017-8-1
 * 
 * Copyright 2001-2016 织巢信息 All rights reserved.
 * 织巢信息 PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.zcnhome.common.pojo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.alibaba.fastjson.annotation.JSONType;
import com.zcnhome.common.utils.BeanToMapUtil;

/**
 * 分页查询型响应数据模型
 * 
 * @author hqsun
 * @since 2017-8-1
 *
 */
@JSONType(ignores = {"searchParam"})
public class Page {
    /**
     * 当前分页号
     */
    private Integer currentPage = 1;

    /**
     * 分页数量
     */
    private Integer pageSize = 10;
    
    /**
     * 总页数
     */
    private Integer pages=1;

    /**
     * 记录总条数
     */
    private Integer total = 0;

    /**
     * 分页数据
     */
    private Collection<?> rows;

    private Map<String, Object> searchParam;

    /**
     * @return the currentPage
     * @see Page#currentPage
     */
    public Integer getCurrentPage() {
        return currentPage;
    }

    /**
     * @param currentPage
     *            the currentPage to set
     * @see Page#currentPage
     */
    public void setCurrentPage(Integer currentPage) {
        if (currentPage != null && currentPage.intValue() > 0) {
            this.currentPage = currentPage;
        }
    }

    /**
     * @return the pageSize
     * @see Page#pageSize
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * @param pageSize
     *            the pageSize to set
     * @see Page#pageSize
     */
    public void setPageSize(Integer pageSize) {
        if (pageSize != null && pageSize.intValue() > 0) {
            this.pageSize = pageSize;
        }
    }
    
    

    /**
     * @return the pages
     */
    public Integer getPages() {
        return pages;
    }

    /**
     * @param pages the pages to set
     */
    public void setPages(Integer pages) {
        this.pages = pages;
    }

    /**
     * @return the total
     * @see Page#total
     */
    public Integer getTotal() {
        return total;
    }

    /**
     * @param total
     *            the total to set
     * @see Page#total
     */
    public void setTotal(Integer total) {
        if (total != null && total.intValue() > 0) {
            this.total = total;
        }
    }

    /**
     * @return the rows
     * @see Page#rows
     */
    public Collection<?> getRows() {
        return rows;
    }

    /**
     * @param rows
     *            the rows to set
     * @see Page#rows
     */
    public Page setRows(Collection<?> rows) {
        this.rows = rows;

        return this;
    }

    public Map<String, Object> getSearchParam() {
        if (null == searchParam) {
            searchParam = new HashMap<>();
        }
        return searchParam;
    }

    public void setSearchParam(Map<String, Object> searchParam) {
        this.searchParam = searchParam;
    }

    public void setSearchParam(Object bean) {
        this.setSearchParam(BeanToMapUtil.convertBean(bean));
    }

    public static Page from(Page page) {
        return null != page ? page : new Page();
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
