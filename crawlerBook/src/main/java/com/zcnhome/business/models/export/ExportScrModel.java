package com.zcnhome.business.models.export;

import com.zcnhome.common.models.BasicModel;

public class ExportScrModel extends BasicModel {
    private Long id;

    private int no;

    private Long exportId;

    private String loopName;

    private String deviceName;

    private String citeFrom;

    private String fireLine;

    private String zeroLine;

    private String groundLine;

    private String pipeLineType;

    public Long getId() {
        return id;
    }

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

    public Long getExportId() {
        return exportId;
    }

    public void setExportId(Long exportId) {
        this.exportId = exportId;
    }

    public String getLoopName() {
        return loopName;
    }

    public void setLoopName(String loopName) {
        this.loopName = loopName == null ? null : loopName.trim();
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName == null ? null : deviceName.trim();
    }

    public String getCiteFrom() {
        return citeFrom;
    }

    public void setCiteFrom(String citeFrom) {
        this.citeFrom = citeFrom == null ? null : citeFrom.trim();
    }

    public String getFireLine() {
        return fireLine;
    }

    public void setFireLine(String fireLine) {
        this.fireLine = fireLine == null ? null : fireLine.trim();
    }

    public String getZeroLine() {
        return zeroLine;
    }

    public void setZeroLine(String zeroLine) {
        this.zeroLine = zeroLine == null ? null : zeroLine.trim();
    }

    public String getGroundLine() {
        return groundLine;
    }

    public void setGroundLine(String groundLine) {
        this.groundLine = groundLine == null ? null : groundLine.trim();
    }

    public String getPipeLineType() {
        return pipeLineType;
    }

    public void setPipeLineType(String pipeLineType) {
        this.pipeLineType = pipeLineType == null ? null : pipeLineType.trim();
    }
}
