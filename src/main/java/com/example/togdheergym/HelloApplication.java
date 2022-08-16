package com.example.togdheergym;

import com.example.togdheergym.models.CustomerDAO;
import com.example.togdheergym.models.UserDAO;
import com.example.togdheergym.objects.Costumers;
import com.example.togdheergym.objects.Users;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.SQLException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("views/login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }

    public static void main(String[] args) throws SQLException {
        UserDAO userDAO = new UserDAO();
        // Users user = new Users(2,"Luul", "Cali", "444444", "Female", "Afternoon", "lul", "1234", "empty", true);
//        userDAO.updateUser(user);

//        Costumers costumers = new
//                Costumers("Usaaame", "Saeed", "888888", "Male", "Afternoon", 22, 1,
//                "Zaad", "blah", true, activeUser.getUsername());
//        model.getCustomerDAO().insertCustomer(costumers);
        System.out.println(userDAO.getUser("yyy"));
        launch();
    }
}