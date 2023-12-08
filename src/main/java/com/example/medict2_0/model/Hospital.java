package com.example.medict2_0.model;

public class Hospital {
    private String HID;
    private String name;
    private String location;
    private String contactNumber;
    private String mailId;
    private String password;
    private int hrefId;

    // Getter and Setter methods for each column

    public String getHID() {
        return HID;
    }

    public void setHID(String HID) {
        this.HID = HID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getHrefId() {
        return hrefId;
    }

    public void setHrefId(int hrefId) {
        this.hrefId = hrefId;
    }
}

