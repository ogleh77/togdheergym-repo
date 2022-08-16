package com.example.togdheergym.controllers;

import com.example.togdheergym.models.UserDAO;
import com.example.togdheergym.objects.Users;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private AnchorPane loginPane;

    @FXML
    private PasswordField password;

    @FXML
    private ComboBox<String> username;
    private UserDAO userDAO;

    public LoginController() {
        userDAO = new UserDAO();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            for (Users user : userDAO.getAllUsers()) {
                username.getItems().add(user.getUsername());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void loginHandler(ActionEvent event) throws SQLException, IOException {
        Users user = userDAO.getUser(username.getValue());
        if (user.getPassword().equals(password.getText())) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/togdheergym/views/sercices/splashscreen.fxml"));
            Scene scene = new Scene(loader.load());
            SplashController controller = loader.getController();
            controller.setActiveUser(user);
            Stage splashStage = new Stage();
            splashStage.initStyle(StageStyle.UNDECORATED);
            splashStage.setScene(scene);
            splashStage.show();
        } else {
            System.out.println("Wrong");
        }
    }

    @FXML
    void closeHandler(MouseEvent event) {
        Stage stage = (Stage) loginPane.getScene().getWindow();
        stage.show();
    }
}
