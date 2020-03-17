package com.example.springboot.demo.entities;

import javax.persistence.*;

@Entity
@Table(name="landloard_phone")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer phoneId;

    @Column(name="phone_areacode")
    private Integer areaCode;

    @Column(name="phone_number")
    private Integer phoneNumber;

    @ManyToOne()
    @JoinColumn(name="landloard_id")
    private LandLoard landLoard;

    public Integer getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(Integer phoneId) {
        this.phoneId = phoneId;
    }

    public Integer getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(Integer areaCode) {
        this.areaCode = areaCode;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LandLoard getLandLoard() {
        return landLoard;
    }

    public void setLandLoard(LandLoard landLoard) {
        this.landLoard = landLoard;
    }
}
