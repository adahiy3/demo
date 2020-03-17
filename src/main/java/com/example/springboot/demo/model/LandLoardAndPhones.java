package com.example.springboot.demo.model;

import java.util.List;

public class LandLoardAndPhones {
    List<LandLoardAndPhone> landLoardAndPhoneList;

    public LandLoardAndPhones() {
    }

    public List<LandLoardAndPhone> getLandLoardAndPhoneList() {
        return landLoardAndPhoneList;
    }

    public void setLandLoardAndPhoneList(List<LandLoardAndPhone> landLoardAndPhoneList) {
        this.landLoardAndPhoneList = landLoardAndPhoneList;
    }
}
