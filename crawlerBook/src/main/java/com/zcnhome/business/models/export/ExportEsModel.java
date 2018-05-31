package com.zcnhome.business.models.export;

import com.zcnhome.common.models.BasicModel;

public class ExportEsModel extends BasicModel {
    private Long id;

    private int no;

    private Long exportId;

    private String bPosition;

    private String bDistanceA;

    private String bDistanceB;

    private String bTrend;

    private Integer length;

    private Integer width;

    private Integer height;

    private String ePosition;

    private String eDistanceA;

    private String eDistanceB;

    private Integer tube;

    private Integer count;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the no
     */
    public int getNo() {
        return no;
    }

    /**
     * @param no
     *            the no to set
     */
    public void setNo(int no) {
        this.no = no;
    }

    /**
     * @return the exportId
     */
    public Long getExportId() {
        return exportId;
    }

    /**
     * @param exportId
     *            the exportId to set
     */
    public void setExportId(Long exportId) {
        this.exportId = exportId;
    }

    /**
     * @return the bPosition
     */
    public String getbPosition() {
        return bPosition;
    }

    /**
     * @param bPosition
     *            the bPosition to set
     */
    public void setbPosition(String bPosition) {
        this.bPosition = bPosition;
    }

    /**
     * @return the bDistanceA
     */
    public String getbDistanceA() {
        return bDistanceA;
    }

    /**
     * @param bDistanceA
     *            the bDistanceA to set
     */
    public void setbDistanceA(String bDistanceA) {
        this.bDistanceA = bDistanceA;
    }

    /**
     * @return the bDistanceB
     */
    public String getbDistanceB() {
        return bDistanceB;
    }

    /**
     * @param bDistanceB
     *            the bDistanceB to set
     */
    public void setbDistanceB(String bDistanceB) {
        this.bDistanceB = bDistanceB;
    }

    /**
     * @return the bTrend
     */
    public String getbTrend() {
        return bTrend;
    }

    /**
     * @param bTrend
     *            the bTrend to set
     */
    public void setbTrend(String bTrend) {
        this.bTrend = bTrend;
    }

    /**
     * @return the length
     */
    public Integer getLength() {
        return length;
    }

    /**
     * @param length
     *            the length to set
     */
    public void setLength(Integer length) {
        this.length = length;
    }

    /**
     * @return the width
     */
    public Integer getWidth() {
        return width;
    }

    /**
     * @param width
     *            the width to set
     */
    public void setWidth(Integer width) {
        this.width = width;
    }

    /**
     * @return the height
     */
    public Integer getHeight() {
        return height;
    }

    /**
     * @param height
     *            the height to set
     */
    public void setHeight(Integer height) {
        this.height = height;
    }

    /**
     * @return the ePosition
     */
    public String getePosition() {
        return ePosition;
    }

    /**
     * @param ePosition
     *            the ePosition to set
     */
    public void setePosition(String ePosition) {
        this.ePosition = ePosition;
    }

    /**
     * @return the eDistanceA
     */
    public String geteDistanceA() {
        return eDistanceA;
    }

    /**
     * @param eDistanceA
     *            the eDistanceA to set
     */
    public void seteDistanceA(String eDistanceA) {
        this.eDistanceA = eDistanceA;
    }

    /**
     * @return the eDistanceB
     */
    public String geteDistanceB() {
        return eDistanceB;
    }

    /**
     * @param eDistanceB
     *            the eDistanceB to set
     */
    public void seteDistanceB(String eDistanceB) {
        this.eDistanceB = eDistanceB;
    }

    /**
     * @return the tube
     */
    public Integer getTube() {
        return tube;
    }

    /**
     * @param tube
     *            the tube to set
     */
    public void setTube(Integer tube) {
        this.tube = tube;
    }

    /**
     * @return the count
     */
    public Integer getCount() {
        return count;
    }

    /**
     * @param count
     *            the count to set
     */
    public void setCount(Integer count) {
        this.count = count;
    }

}
