package com.example.medict2_0.model;

import java.sql.Date;

public class Schedule {
    private int scID;
    private String dID;
    private String hID;
    private Date date;
    private String time;
    private int slots;

    // Getter and Setter methods for scID
    public int getScID() {
        return scID;
    }

    public void setScID(int scID) {
        this.scID = scID;
    }

    // Getter and Setter methods for dID
    public String getdID() {
        return dID;
    }

    public void setdID(String dID) {
        this.dID = dID;
    }

    // Getter and Setter methods for hID
    public String gethID() {
        return hID;
    }

    public void sethID(String hID) {
        this.hID = hID;
    }

    // Getter and Setter methods for date
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    // Getter and Setter methods for time
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    // Getter and Setter methods for slots
    public int getSlots() {
        return slots;
    }

    public void setSlots(int slots) {
        this.slots = slots;
    }
}

