package com.example.togdheergym.controllers;

import com.example.togdheergym.models.Model;
import com.example.togdheergym.objects.TempCostumers;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class NotificationsController implements Initializable {
    @FXML
    private TableColumn<TempCostumers, Integer> costumerId;

    @FXML
    private TableColumn<TempCostumers, String> datejoined;

    @FXML
    private TableColumn<TempCostumers, String> expDate;

    @FXML
    private TableColumn<TempCostumers, String> fname;

    @FXML
    private TableColumn<TempCostumers, String> lname;

    @FXML
    private TableColumn<TempCostumers, String> phone;

    @FXML
    private TableView<TempCostumers> tableView;

    private Model model;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void setModel(ObservableList<TempCostumers> tempCostumers) {
        this.model = model;
        costumerId.setCellValueFactory(new PropertyValueFactory<TempCostumers, Integer>("tempId"));
        fname.setCellValueFactory(new PropertyValueFactory<TempCostumers, String>("firstName"));
        lname.setCellValueFactory(new PropertyValueFactory<TempCostumers, String>("lasttName"));
        phone.setCellValueFactory(new PropertyValueFactory<TempCostumers, String>("phone"));
        datejoined.setCellValueFactory(new PropertyValueFactory<TempCostumers, String>("timeJoined"));
        expDate.setCellValueFactory(new PropertyValueFactory<TempCostumers, String>("expTime"));


        tableView.setItems(tempCostumers);
    }
}
