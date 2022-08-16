package com.example.togdheergym.controllers;

import animatefx.animation.SlideInLeft;
import animatefx.animation.SlideOutLeft;
import com.example.togdheergym.generalize.GeneralClass;
import com.example.togdheergym.models.Model;
import com.example.togdheergym.objects.TempCostumers;
import com.example.togdheergym.objects.Users;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController extends GeneralClass implements Initializable {
    private Model model;
    @FXML
    private BorderPane borderPane;

    @FXML
    private VBox menuPane;

    @FXML
    private VBox sidePane;

    @FXML
    private StackPane stack;

    @FXML
    private Label username;
    private ObservableList<TempCostumers> tempCostumers;

    public DashboardController() {
        this.tempCostumers = FXCollections.observableArrayList();
        this.tempCostumers.add(new TempCostumers("Mohamed", "Saeed", "44444", "Male", 2, "edahab", true));
        this.tempCostumers.add(new TempCostumers("Jamac", "Khadar", "44444", "Male", 2, "edahab", true));
        this.tempCostumers.add(new TempCostumers("Yusuf", "Hassan", "44444", "Male", 2, "edahab", true));

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void setModel(Model model, Users activeUser) {
        this.model = model;
        username.setText(activeUser.getUsername());
    }


    @FXML
    void homeOpenHandler(ActionEvent event) {

    }

    @FXML
    void loanHandler(ActionEvent event) {

    }

    @FXML
    void monthlyRegHandler(ActionEvent event) throws IOException {
        openWindow("/com/example/togdheerGym/views/registrations.fxml", borderPane, stack);
    }

    @FXML
    void openSideHandler(MouseEvent event) {
        if (borderPane.getLeft() == null) {
            new SlideInLeft(sidePane).play();
            borderPane.setLeft(sidePane);
        } else {
            SlideOutLeft slideOutLeft = new SlideOutLeft(sidePane);
            slideOutLeft.play();
            slideOutLeft.setOnFinished(e -> {
                borderPane.setLeft(null);
                borderPane.getCenter().setStyle("-fx-background-size: 1057 626;-fx-background-color: black;-fx-opacity: 0.8");
            });

        }
    }

    @FXML
    void outdatedHandler(ActionEvent event) throws IOException {
        FXMLLoader loader = openShortWindow("/com/example/togdheerGym/views/notifications.fxml", stack);
        NotificationsController controller = loader.getController();
        controller.setModel(tempCostumers);
    }

    @FXML
    void shortlyRegHandler(ActionEvent event) throws IOException {
        openShortWindow("/com/example/togdheerGym/views/shortlyreg.fxml", stack);
    }
}
