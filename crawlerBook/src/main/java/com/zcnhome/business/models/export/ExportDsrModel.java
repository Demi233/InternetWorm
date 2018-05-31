package com.zcnhome.business.models.export;

import com.zcnhome.common.models.BasicModel;

/**
 * 
 * 立面开槽放线说明表
 * 
 * @author mike
 * @since 2017年9月9日
 * @see [Class/Method]
 *
 */
public class ExportDsrModel extends BasicModel {
    private Long id;

    private int no;

    private Long exportId;

    private String loopNum;

    private String loopName;

    private String citeFrom;

    private String materialQuality;

    private String wireHarness;

    private String byLine;

    private String groundLine;

    private Integer pipeDiameter;

    private String openType;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
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
     * @param no the no to set
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
     * @param exportId the exportId to set
     */
    public void setExportId(Long exportId) {
        this.exportId = exportId;
    }

    /**
     * @return the loopNum
     */
    public String getLoopNum() {
        return loopNum;
    }

    /**
     * @param loopNum the loopNum to set
     */
    public void setLoopNum(String loopNum) {
        this.loopNum = loopNum;
    }

    /**
     * @return the loopName
     */
    public String getLoopName() {
        return loopName;
    }

    /**
     * @param loopName the loopName to set
     */
    public void setLoopName(String loopName) {
        this.loopName = loopName;
    }

    /**
     * @return the citeFrom
     */
    public String getCiteFrom() {
        return citeFrom;
    }

    /**
     * @param citeFrom the citeFrom to set
     */
    public void setCiteFrom(String citeFrom) {
        this.citeFrom = citeFrom;
    }

    /**
     * @return the materialQuality
     */
    public String getMaterialQuality() {
        return materialQuality;
    }

    /**
     * @param materialQuality the materialQuality to set
     */
    public void setMaterialQuality(String materialQuality) {
        this.materialQuality = materialQuality;
    }

    /**
     * @return the wireHarness
     */
    public String getWireHarness() {
        return wireHarness;
    }

    /**
     * @param wireHarness the wireHarness to set
     */
    public void setWireHarness(String wireHarness) {
        this.wireHarness = wireHarness;
    }

    /**
     * @return the byLine
     */
    public String getByLine() {
        return byLine;
    }

    /**
     * @param byLine the byLine to set
     */
    public void setByLine(String byLine) {
        this.byLine = byLine;
    }

    /**
     * @return the groundLine
     */
    public String getGroundLine() {
        return groundLine;
    }

    /**
     * @param groundLine the groundLine to set
     */
    public void setGroundLine(String groundLine) {
        this.groundLine = groundLine;
    }

    /**
     * @return the pipeDiameter
     */
    public Integer getPipeDiameter() {
        return pipeDiameter;
    }

    /**
     * @param pipeDiameter the pipeDiameter to set
     */
    public void setPipeDiameter(Integer pipeDiameter) {
        this.pipeDiameter = pipeDiameter;
    }

    /**
     * @return the openType
     */
    public String getOpenType() {
        return openType;
    }

    /**
     * @param openType the openType to set
     */
    public void setOpenType(String openType) {
        this.openType = openType;
    }

    
}
