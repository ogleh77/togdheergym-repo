package com.example.togdheergym.objects;

public class TempCostumers {
    private int tempId;
    private String firstName;
    private String lasttName;
    private String phone;
    private String gender;
    private double paid;
    private String paidBy;
    private boolean poxing;
    private String timeJoined;
    private String expTime;

    public TempCostumers(int tempId, String firstName, String lasttName, String phone, String gender, double paid, String paidBy, boolean poxing, String timeJoined, String expTime) {
        this.tempId = tempId;
        this.firstName = firstName;
        this.lasttName = lasttName;
        this.phone = phone;
        this.gender = gender;
        this.paid = paid;
        this.paidBy = paidBy;
        this.poxing = poxing;
        this.timeJoined = timeJoined;
        this.expTime = expTime;
    }

    public TempCostumers(String firstName, String lasttName, String phone, String gender, double paid, String paidBy, boolean poxing) {
        this.firstName = firstName;
        this.lasttName = lasttName;
        this.phone = phone;
        this.gender = gender;
        this.paid = paid;
        this.paidBy = paidBy;
        this.poxing = poxing;
    }


    public int getTempId() {
        return tempId;
    }

    public void setTempId(int tempId) {
        this.tempId = tempId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLasttName() {
        return lasttName;
    }

    public void setLasttName(String lasttName) {
        this.lasttName = lasttName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getPaid() {
        return paid;
    }

    public void setPaid(double paid) {
        this.paid = paid;
    }

    public String getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(String paidBy) {
        this.paidBy = paidBy;
    }

    public boolean getPoxing() {
        return poxing;
    }

    public void setPoxing(boolean poxing) {
        this.poxing = poxing;
    }

    public String getTimeJoined() {
        return timeJoined;
    }

    public void setTimeJoined(String timeJoined) {
        this.timeJoined = timeJoined;
    }

    public String getExpTime() {
        return expTime;
    }

    public void setExpTime(String expTime) {
        this.expTime = expTime;
    }

    @Override
    public String toString() {
        return "TempCostumers{" +
                "tempId=" + tempId +
                ", firstName='" + firstName + '\'' +
                ", lasttName='" + lasttName + '\'' +
                ", phone='" + phone + '\'' +
                ", gender='" + gender + '\'' +
                ", paid=" + paid +
                ", paidBy='" + paidBy + '\'' +
                ", poxing=" + poxing +
                ", timeJoined='" + timeJoined + '\'' +
                ", expTime='" + expTime + '\'' +
                '}';
    }
}
