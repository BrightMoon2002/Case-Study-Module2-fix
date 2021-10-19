package model.idol;

import java.io.Serializable;
import java.util.Objects;

public class Idol extends BaseIdol implements Serializable {
    private String stageName;
    private String dOB;
    private double height;
    private String bodyMeasurements;
    private String service;
    private double tip;
    private boolean status;
    private int countChecker;
    private String id;

    public Idol() {
    }

    public Idol(String stageName, String dOB, double height, String bodyMeasurements, String service, double tip, boolean status, int countChecker) {
        this.stageName = stageName;
        this.dOB = dOB;
        this.height = height;
        this.bodyMeasurements = bodyMeasurements;
        this.service = service;
        this.tip = tip;
        this.status = status;
        this.countChecker = countChecker;
    }

    public Idol(String stageName, String dOB, double height, String bodyMeasurement, String id) {
        this.stageName = stageName;
        this.dOB = dOB;
        this.height = height;
        this.bodyMeasurements = bodyMeasurement;
        this.id = id;
    }

    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    public String getdOB() {
        return dOB;
    }

    public void setdOB(String dOB) {
        this.dOB = dOB;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getBodyMeasurements() {
        return bodyMeasurements;
    }

    public void setBodyMeasurements(String bodyMeasurements) {
        this.bodyMeasurements = bodyMeasurements;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public double getTip() {
        return tip;
    }

    public void setTip(double tip) {
        this.tip = tip;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getCountChecker() {
        return countChecker;
    }

    public void setCountChecker(int countChecker) {
        this.countChecker = countChecker;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Idol{" +
                "stageName='" + stageName + '\'' +
                ", id=" + id +
                ", dOB='" + dOB + '\'' +
                ", height=" + height +
                ", bodyMeasurements='" + bodyMeasurements + '\'' +
                ", service='" + service + '\'' +
                ", tip=" + tip +
                ", status=" + status +
                ", countChecker=" + countChecker +
                '}';
    }
}
