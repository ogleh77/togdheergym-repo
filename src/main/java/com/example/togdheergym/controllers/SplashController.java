package com.example.togdheergym.controllers;

import animatefx.animation.FadeOut;
import com.example.togdheergym.models.Model;
import com.example.togdheergym.objects.Users;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SplashController implements Initializable {

    @FXML
    private Label loading;

    @FXML
    private ProgressBar progres;

    @FXML
    private Circle userImage;

    @FXML
    private Label username;

    private Users activeUser;

    private Model model;

    public SplashController() throws SQLException {
        this.model = new Model();
    }

    public void setActiveUser(Users activeUser) {
        this.activeUser = activeUser;
        Thread thread = new Thread(model);
        thread.setDaemon(true);
        thread.start();

        progres.progressProperty().bind(model.progressProperty());
        loading.textProperty().bind(model.messageProperty());
        username.setText("welcome " + activeUser.getUsername());
    }

    @FXML
    void logoutHandler(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        model.setOnSucceeded(e -> {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/togdheergym/views/dashboardFXML.fxml"));
            Scene scene = null;
            try {
                scene = new Scene(loader.load());
                DashboardController controller = loader.getController();
                controller.setModel(model, activeUser);
                Stage dashboardStage = new Stage();
                dashboardStage.initStyle(StageStyle.UNDECORATED);
                dashboardStage.setScene(scene);
                FadeOut fadeOut = new FadeOut(progres.getParent());
                fadeOut.play();
                Stage splashSatge = (Stage) progres.getScene().getWindow();
                fadeOut.setOnFinished(b -> {
                    splashSatge.close();
                    dashboardStage.show();
                });

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

    }
}
