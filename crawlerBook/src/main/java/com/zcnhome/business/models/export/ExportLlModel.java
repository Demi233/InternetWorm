package com.zcnhome.business.models.export;

import com.zcnhome.common.models.BasicModel;

public class ExportLlModel extends BasicModel {
    private Long id;

    private int no;

    private Long exportId;

    private String deviceName;

    private String position;

    private String distanceA;

    private String distanceB;

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
     * @return the deviceName
     */
    public String getDeviceName() {
        return deviceName;
    }

    /**
     * @param deviceName
     *            the deviceName to set
     */
    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    /**
     * @return the position
     */
    public String getPosition() {
        return position;
    }

    /**
     * @param position
     *            the position to set
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * @return the distanceA
     */
    public String getDistanceA() {
        return distanceA;
    }

    /**
     * @param distanceA
     *            the distanceA to set
     */
    public void setDistanceA(String distanceA) {
        this.distanceA = distanceA;
    }

    /**
     * @return the distanceB
     */
    public String getDistanceB() {
        return distanceB;
    }

    /**
     * @param distanceB
     *            the distanceB to set
     */
    public void setDistanceB(String distanceB) {
        this.distanceB = distanceB;
    }

}
