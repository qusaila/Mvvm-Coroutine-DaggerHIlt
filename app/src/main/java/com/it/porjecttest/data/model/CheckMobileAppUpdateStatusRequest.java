package com.it.porjecttest.data.model;

public class CheckMobileAppUpdateStatusRequest {


    private int DeviceType;
    private String CurrentVersion;

    public int getDeviceType() {
        return DeviceType;
    }

    public void setDeviceType(int deviceType) {
        DeviceType = deviceType;
    }

    public String getCurrentVersion() {
        return CurrentVersion;
    }

    public void setCurrentVersion(String currentVersion) {
        CurrentVersion = currentVersion;
    }
}