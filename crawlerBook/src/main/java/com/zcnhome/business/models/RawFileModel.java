package com.zcnhome.business.models;

import java.util.Date;

import com.zcnhome.common.models.FileUpResModel;

/**
 * Model class of t_raw_file
 * 原始文件MD5映射信息
 * 
 * @author hqsun
 * @since 2017-8-1
 */
public class RawFileModel extends FileUpResModel {

    /**
     * MD5（文件名+UUID）摘要
     */
    private String num;

    /**
     * 原文件名
     */
    private String fileName;

    /**
     * 存储路径
     */
    private String filePath;

    /**
     * 文件业务类型
     */
    private Integer type;

    /**
     * 创建人id
     */
    private Long creator;

    /**
     * 修改人id
     */
    private Long modifier;

    /**
     * 创建时间：Y-m-d H:i:S
     */
    private Date createTime;

    /**
     * 修改时间：Y-m-d H:i:S
     */
    private Date modifyTime;

    /**
     * Get the num
     * 
     * @return num
     *         MD5（文件名+UUID）摘要
     */
    public String getNum() {
        return this.num;
    }

    /**
     * Set the num
     * 
     * @param num
     *            MD5（文件名+UUID）摘要
     */
    public void setNum(String num) {
        this.num = num;
    }

    /**
     * Get the fileName
     * 
     * @return fileName
     *         原文件名
     */
    public String getFileName() {
        return this.fileName;
    }

    /**
     * Set the fileName
     * 
     * @param fileName
     *            原文件名
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Get the filePath
     * 
     * @return filePath
     *         存储路径
     */
    public String getFilePath() {
        return this.filePath;
    }

    /**
     * Set the filePath
     * 
     * @param filePath
     *            存储路径
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Get the type
     * 
     * @return type
     *         1,用户头像；2,电子书；3,教辅文件；4,电子书封面；5,教辅封面；6,公开课封面；7,轮播图；8,名师封面；9,最新资讯图片；
     *         10,题目图片；11,友情链接图片；12,二维码图片
     */
    public Integer getType() {
        return this.type;
    }

    /**
     * Set the type
     * 
     * @param type
     *            1,用户头像；2,电子书；3,教辅文件；4,电子书封面；5,教辅封面；6,公开课封面；7,轮播图；8,名师封面；9,
     *            最新资讯图片；10,题目图片；11,友情链接图片；12,二维码图片
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * Get the creator
     * 
     * @return creator
     *         创建人id
     */
    public Long getCreator() {
        return this.creator;
    }

    /**
     * Set the creator
     * 
     * @param creator
     *            创建人id
     */
    public void setCreator(Long creator) {
        this.creator = creator;
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
     * Get the createTime
     * 
     * @return createTime
     *         创建时间：Y-m-d H:i:S
     */
    public Date getCreateTime() {
        return this.createTime;
    }

    /**
     * Set the createTime
     * 
     * @param createTime
     *            创建时间：Y-m-d H:i:S
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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


}
