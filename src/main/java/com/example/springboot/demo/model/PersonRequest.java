package com.example.springboot.demo.model;

public class PersonRequest {
    Integer page;
    Integer numberofRecords;
    String firstName;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getNumberofRecords() {
        return numberofRecords;
    }

    public void setNumberofRecords(Integer numberofRecords) {
        this.numberofRecords = numberofRecords;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
