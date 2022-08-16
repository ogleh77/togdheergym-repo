package com.example.togdheergym.interfaces;

import com.example.togdheergym.objects.Users;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface UsersModel {
    void insertUser(Users user) throws SQLException;

    void updateUser(Users user) throws SQLException;

    boolean deleteUser(Users user) throws SQLException;

    ObservableList<Users> getAllUsers() throws SQLException;

    Users getUser(String username) throws SQLException;
}
