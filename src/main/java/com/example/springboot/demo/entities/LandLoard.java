package com.example.springboot.demo.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "land_loard")
public class LandLoard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "landloard_id")
    private Integer id;

    @Column(name="landloard_name")
    private String name;

    @Column(name = "landloard_nickname")
    private String nickName;

    @Column(name = "landloard_createdon")
    private Date createdOn;

    @Column(name = "ladloard_address")
    private String address;

    @OneToMany(mappedBy = "landLoard",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Phone> phoneList = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Phone> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<Phone> phoneList) {
        this.phoneList = phoneList;
    }
}
