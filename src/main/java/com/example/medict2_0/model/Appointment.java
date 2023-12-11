package com.example.medict2_0.model;

public class Appointment {
    private String AID;
    private String PID;
    private String DID;
    private String HID;
    private String SID;
    private String DT;
    private String status;

    public Appointment(String aid, String pid, String did, String hid, String sid, String dt, String status) {
        System.out.println("AID: " + aid + ", PID: " + pid + ", DID: " + did + ", HID: " + hid + ", SID: " + sid + ", DT: " + dt + ", Status: " + status);
        this.AID = aid;
        this.PID = pid;
        this.DID = did;
        this.HID = hid;
        this.SID = sid;
        this.DT = dt;
        this.status = status;
    }

    public String getAID() {
        return AID;
    }

    public void setAID(String AID) {
        this.AID = AID;
    }

    public String getPID() {
        return PID;
    }

    public void setPID(String PID) {
        this.PID = PID;
    }

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

    public String getSID() {
        return SID;
    }

    public void setSID(String SID) {
        this.SID = SID;
    }

    public String getDT() {
        return DT;
    }

    public void setDT(String DT) {
        this.DT = DT;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

