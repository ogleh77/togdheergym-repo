package com.example.togdheergym.objects;

import com.jfoenix.controls.JFXButton;
import javafx.beans.property.*;

public class Costumers {
    private int costumerId;
    private String firstName;
    private String lastName;
    private String phone;
    private String gender;
    private String shift;
    private double paid;
    private double discount;
    private String paidBy;
    private String image;
    private boolean poxing;
    private String whoAdded;
    private String dateJoined;
    private String expDate;
    private JFXButton infoBtn;
    private JFXButton editBtn;

    public Costumers(int costumerId, String firstName, String lastName, String phone, String gender, String shift, double paid, double discount, String paidBy, String image, boolean poxing, String whoAdded) {
        this.costumerId = costumerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.gender = gender;
        this.shift = shift;
        this.paid = paid;
        this.discount = discount;
        this.paidBy = paidBy;
        this.image = image;
        this.poxing = poxing;
        this.whoAdded = whoAdded;
    }

    public Costumers(int costumerId, String firstName, String lastName, String phone, String gender, String shift, double paid, double discount, String paidBy, String image, boolean poxing, String whoAdded, String dateJoined, String expDate) {
        this.costumerId = costumerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.gender = gender;
        this.shift = shift;
        this.paid = paid;
        this.discount = discount;
        this.paidBy = paidBy;
        this.image = image;
        this.poxing = poxing;
        this.whoAdded = whoAdded;
        this.dateJoined = dateJoined;
        this.expDate = expDate;
        this.infoBtn = new JFXButton("Delete");
        this.editBtn = new JFXButton("Edit");
        infoBtn.setStyle("-fx-background-color: red;-fx-font-size: 12;-fx-font-family: 'Arial Black';-fx-text-fill: white");
        editBtn.setStyle("-fx-background-color: dodgerblue;-fx-font-size: 12;-fx-font-family: 'Arial Black';-fx-text-fill: white");
    }

    public Costumers(String firstName, String lastName, String phone, String gender, String shift, double paid, double discount, String paidBy, String image, boolean poxing, String whoAdded) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.gender = gender;
        this.shift = shift;
        this.paid = paid;
        this.discount = discount;
        this.paidBy = paidBy;
        this.image = image;
        this.poxing = poxing;
        this.whoAdded = whoAdded;
    }

    public int getCostumerId() {
        return costumerId;
    }

    public void setCostumerId(int costumerId) {
        this.costumerId = costumerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public double getPaid() {
        return paid;
    }

    public void setPaid(double paid) {
        this.paid = paid;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(String paidBy) {
        this.paidBy = paidBy;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isPoxing() {
        return poxing;
    }

    public void setPoxing(boolean poxing) {
        this.poxing = poxing;
    }

    public String getWhoAdded() {
        return whoAdded;
    }

    public void setWhoAdded(String whoAdded) {
        this.whoAdded = whoAdded;
    }

    public String getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(String dateJoined) {
        this.dateJoined = dateJoined;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public JFXButton getInfoBtn() {
        return infoBtn;
    }

    public void setInfoBtn(JFXButton infoBtn) {
        this.infoBtn = infoBtn;
    }

    public JFXButton getEditBtn() {
        return editBtn;
    }

    public void setEditBtn(JFXButton editBtn) {
        this.editBtn = editBtn;
    }

    @Override
    public String toString() {
        return "Costumers{" +
                "costumerId=" + costumerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", gender='" + gender + '\'' +
                ", shift='" + shift + '\'' +
                ", paid=" + paid +
                ", discount=" + discount +
                ", paidBy='" + paidBy + '\'' +
                ", image='" + image + '\'' +
                ", poxing=" + poxing +
                ", whoAdded='" + whoAdded + '\'' +
                ", dateJoined='" + dateJoined + '\'' +
                ", expDate='" + expDate + '\'' +
                '}';
    }
}