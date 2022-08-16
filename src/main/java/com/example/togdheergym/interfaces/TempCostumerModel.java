package com.example.togdheergym.interfaces;

import com.example.togdheergym.objects.TempCostumers;
import com.example.togdheergym.objects.Users;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface TempCostumerModel {
    void insertUser(TempCostumers tempCostumer) throws SQLException;

    void updateUser(TempCostumers tempCostumer) throws SQLException;

    boolean deleteUser(TempCostumers tempCostumer) throws SQLException;

    ObservableList<TempCostumers> getAllTempCostumers() throws SQLException;

    TempCostumers getTempCostumer(String username) throws SQLException;
}
