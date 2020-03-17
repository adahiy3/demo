package com.example.springboot.demo.model;

public class LandLoardAndPhone {
    String landLoardName;
    String landLoardNickName;
    String landLoardAddress;
    String areaCode;
    String phoneNumber;


    public LandLoardAndPhone() {
    }

    public String getLandLoardName() {
        return landLoardName;
    }

    public void setLandLoardName(String landLoardName) {
        this.landLoardName = landLoardName;
    }

    public String getLandLoardNickName() {
        return landLoardNickName;
    }

    public void setLandLoardNickName(String landLoardNickName) {
        this.landLoardNickName = landLoardNickName;
    }

    public String getLandLoardAddress() {
        return landLoardAddress;
    }

    public void setLandLoardAddress(String landLoardAddress) {
        this.landLoardAddress = landLoardAddress;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
