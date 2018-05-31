package com.zcnhome.business.models.export;

import java.util.List;

import com.zcnhome.common.models.BasicModel;

/**
 * 
 * 水电线路导出记录模型
 * 
 * @author mike
 * @since 2017年9月9日
 * @see [Class/Method]
 *
 */
public class ExportRecordModel extends BasicModel {
    private Long id;

    private Long designId;

    private String designName;

    private String designerUnit;

    private String constAddress;

    private String projectName;

    private Long designerId;

    private String designer;

    private String village;

    private String ssPlan;

    private String llPlan;

    private String spPlan;

    private String esFacade;

    private String dsrDiagram;

    private String dbNum;

    private String loopCount;

    private String scrDiagram;

    private String lsrDiagram;

    private String createTime;

    List<ExportDsrModel> dsrList;
    
    List<ExportEsModel> esList;
    
    List<ExportLlModel> llList;
    
    List<ExportLsrModel> lsrList;
    
    List<ExportScrModel> scrList;
    
    List<ExportSpModel> spList;
    
    List<ExportSsModel> ssList;

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
     * @return the designId
     */
    public Long getDesignId() {
        return designId;
    }

    /**
     * @param designId
     *            the designId to set
     */
    public void setDesignId(Long designId) {
        this.designId = designId;
    }

    /**
     * @return the designName
     */
    public String getDesignName() {
        return designName;
    }

    /**
     * @param designName
     *            the designName to set
     */
    public void setDesignName(String designName) {
        this.designName = designName;
    }

    /**
     * @return the designerUnit
     */
    public String getDesignerUnit() {
        return designerUnit;
    }

    /**
     * @param designerUnit
     *            the designerUnit to set
     */
    public void setDesignerUnit(String designerUnit) {
        this.designerUnit = designerUnit;
    }

    /**
     * @return the constAddress
     */
    public String getConstAddress() {
        return constAddress;
    }

    /**
     * @param constAddress
     *            the constAddress to set
     */
    public void setConstAddress(String constAddress) {
        this.constAddress = constAddress;
    }

    /**
     * @return the projectName
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * @param projectName
     *            the projectName to set
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     * @return the designerId
     */
    public Long getDesignerId() {
        return designerId;
    }

    /**
     * @param designerId
     *            the designerId to set
     */
    public void setDesignerId(Long designerId) {
        this.designerId = designerId;
    }

    /**
     * @return the designer
     */
    public String getDesigner() {
        return designer;
    }

    /**
     * @param designer
     *            the designer to set
     */
    public void setDesigner(String designer) {
        this.designer = designer;
    }

    /**
     * @return the village
     */
    public String getVillage() {
        return village;
    }

    /**
     * @param village
     *            the village to set
     */
    public void setVillage(String village) {
        this.village = village;
    }

    /**
     * @return the ssPlan
     */
    public String getSsPlan() {
        return ssPlan;
    }

    /**
     * @param ssPlan
     *            the ssPlan to set
     */
    public void setSsPlan(String ssPlan) {
        this.ssPlan = ssPlan;
    }

    /**
     * @return the llPlan
     */
    public String getLlPlan() {
        return llPlan;
    }

    /**
     * @param llPlan
     *            the llPlan to set
     */
    public void setLlPlan(String llPlan) {
        this.llPlan = llPlan;
    }

    /**
     * @return the spPlan
     */
    public String getSpPlan() {
        return spPlan;
    }

    /**
     * @param spPlan
     *            the spPlan to set
     */
    public void setSpPlan(String spPlan) {
        this.spPlan = spPlan;
    }

    /**
     * @return the esFacade
     */
    public String getEsFacade() {
        return esFacade;
    }

    /**
     * @param esFacade
     *            the esFacade to set
     */
    public void setEsFacade(String esFacade) {
        this.esFacade = esFacade;
    }

    /**
     * @return the dsrDiagram
     */
    public String getDsrDiagram() {
        return dsrDiagram;
    }

    /**
     * @param dsrDiagram
     *            the dsrDiagram to set
     */
    public void setDsrDiagram(String dsrDiagram) {
        this.dsrDiagram = dsrDiagram;
    }

    /**
     * @return the dbNum
     */
    public String getDbNum() {
        return dbNum;
    }

    /**
     * @param dbNum
     *            the dbNum to set
     */
    public void setDbNum(String dbNum) {
        this.dbNum = dbNum;
    }

    /**
     * @return the loopCount
     */
    public String getLoopCount() {
        return loopCount;
    }

    /**
     * @param loopCount
     *            the loopCount to set
     */
    public void setLoopCount(String loopCount) {
        this.loopCount = loopCount;
    }

    /**
     * @return the scrDiagram
     */
    public String getScrDiagram() {
        return scrDiagram;
    }

    /**
     * @param scrDiagram
     *            the scrDiagram to set
     */
    public void setScrDiagram(String scrDiagram) {
        this.scrDiagram = scrDiagram;
    }

    /**
     * @return the lsrDiagram
     */
    public String getLsrDiagram() {
        return lsrDiagram;
    }

    /**
     * @param lsrDiagram
     *            the lsrDiagram to set
     */
    public void setLsrDiagram(String lsrDiagram) {
        this.lsrDiagram = lsrDiagram;
    }

    /**
     * @return the createTime
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     *            the createTime to set
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    /**
     * @return the ssList
     */
    public List<ExportSsModel> getSsList() {
        return ssList;
    }

    /**
     * @param ssList
     *            the ssList to set
     */
    public void setSsList(List<ExportSsModel> ssList) {
        this.ssList = ssList;
    }

    /**
     * @return the dsrList
     */
    public List<ExportDsrModel> getDsrList() {
        return dsrList;
    }

    /**
     * @param dsrList the dsrList to set
     */
    public void setDsrList(List<ExportDsrModel> dsrList) {
        this.dsrList = dsrList;
    }

    /**
     * @return the esList
     */
    public List<ExportEsModel> getEsList() {
        return esList;
    }

    /**
     * @param esList the esList to set
     */
    public void setEsList(List<ExportEsModel> esList) {
        this.esList = esList;
    }

    /**
     * @return the llList
     */
    public List<ExportLlModel> getLlList() {
        return llList;
    }

    /**
     * @param llList the llList to set
     */
    public void setLlList(List<ExportLlModel> llList) {
        this.llList = llList;
    }

    /**
     * @return the lsrList
     */
    public List<ExportLsrModel> getLsrList() {
        return lsrList;
    }

    /**
     * @param lsrList the lsrList to set
     */
    public void setLsrList(List<ExportLsrModel> lsrList) {
        this.lsrList = lsrList;
    }

    /**
     * @return the scrList
     */
    public List<ExportScrModel> getScrList() {
        return scrList;
    }

    /**
     * @param scrList the scrList to set
     */
    public void setScrList(List<ExportScrModel> scrList) {
        this.scrList = scrList;
    }

    /**
     * @return the spList
     */
    public List<ExportSpModel> getSpList() {
        return spList;
    }

    /**
     * @param spList the spList to set
     */
    public void setSpList(List<ExportSpModel> spList) {
        this.spList = spList;
    }
    
}
