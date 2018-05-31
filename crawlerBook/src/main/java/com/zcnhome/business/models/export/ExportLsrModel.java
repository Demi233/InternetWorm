package com.zcnhome.business.models.export;

import com.zcnhome.common.models.BasicModel;

public class ExportLsrModel extends BasicModel {
    private Long id;

    private int no;

    private Long exportId;

    private String loopName;

    private String lampName;

    private String roomName;

    private String lampGroup;

    private String switchType;

    private String controlledSwitchName;

    private String fireLine;

    private String zeroLine;

    private String installMethod;

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

    public String getLampName() {
        return lampName;
    }

    public void setLampName(String lampName) {
        this.lampName = lampName == null ? null : lampName.trim();
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName == null ? null : roomName.trim();
    }

    public String getLampGroup() {
        return lampGroup;
    }

    public void setLampGroup(String lampGroup) {
        this.lampGroup = lampGroup == null ? null : lampGroup.trim();
    }

    public String getSwitchType() {
        return switchType;
    }

    public void setSwitchType(String switchType) {
        this.switchType = switchType == null ? null : switchType.trim();
    }

    public String getControlledSwitchName() {
        return controlledSwitchName;
    }

    public void setControlledSwitchName(String controlledSwitchName) {
        this.controlledSwitchName = controlledSwitchName == null ? null : controlledSwitchName.trim();
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

    public String getInstallMethod() {
        return installMethod;
    }

    public void setInstallMethod(String installMethod) {
        this.installMethod = installMethod == null ? null : installMethod.trim();
    }

    public String getPipeLineType() {
        return pipeLineType;
    }

    public void setPipeLineType(String pipeLineType) {
        this.pipeLineType = pipeLineType == null ? null : pipeLineType.trim();
    }
}
