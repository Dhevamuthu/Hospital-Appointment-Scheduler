package com.example.medict2_0.model;

public class Doctor {
    private String DID;
    private String HID;
    private String name;
    private String mailid;
    private String password;
    private int medicalRegId;
    private int experience;
    private String qualification;
    private String parentDoctorId;
    private String SID;

    public String getDID() {
        return DID;
    }

    public void setDID(String DID) {
        this.DID = DID;
    }

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

    public String getMailid() {
        return mailid;
    }

    public void setMailid(String mailid) {
        this.mailid = mailid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMedicalRegId() {
        return medicalRegId;
    }

    public void setMedicalRegId(int medicalRegId) {
        this.medicalRegId = medicalRegId;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getParentDoctorId() {
        return parentDoctorId;
    }

    public void setParentDoctorId(String parentDoctorId) {
        this.parentDoctorId = parentDoctorId;
    }

    public String getSID() {
        return SID;
    }

    public void setSID(String SID) {
        this.SID = SID;
    }
}


