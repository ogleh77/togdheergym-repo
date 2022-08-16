package com.example.togdheergym.controllers;

import com.example.togdheergym.generalize.GeneralClass;
import com.example.togdheergym.models.TempDAO;
import com.example.togdheergym.objects.TempCostumers;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXRadioButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ShortlyRegController extends GeneralClass implements Initializable {
    @FXML
    private TextField amountPaid;

    @FXML
    private JFXRadioButton female;

    @FXML
    private TextField firstname;

    @FXML
    private TextField lastName;

    @FXML
    private JFXRadioButton male;

    @FXML
    private ComboBox<String> paidBy;

    @FXML
    private TextField phone;

    @FXML
    private JFXCheckBox poxing;
    private TempDAO tempDAO;

    public ShortlyRegController() {
        this.tempDAO = new TempDAO();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    void onSubmitHandler(ActionEvent event) {
        selected(male, female);
        isPoxing(poxing);
        try {
            TempCostumers tempCostumer = new TempCostumers(firstname.getText(), lastName.getText(),
                    phone.getText(), getGender(), Double.parseDouble(amountPaid.getText()), paidBy.getValue(),isPoxing(poxing));

            tempDAO.insertUser(tempCostumer);


            getAlert(Alert.AlertType.INFORMATION, "Short time Costumer", "Short time costumer added seccessfully");
          //  System.out.println(tempCostumer);
        } catch (Exception e) {
            getAlert(Alert.AlertType.ERROR, "Something went wrong", "Error! " + e.getMessage());
        }

    }
}

