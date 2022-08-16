package com.example.togdheergym.models;

import com.example.togdheergym.interfaces.TempCostumerModel;
import com.example.togdheergym.objects.TempCostumers;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public class TempDAO implements TempCostumerModel {
    @Override
    public void insertUser(TempCostumers tempCostumer) throws SQLException {
        System.out.println("Saved...");
        System.out.println(tempCostumer);
    }

    @Override
    public void updateUser(TempCostumers tempCostumer) throws SQLException {

    }

    @Override
    public boolean deleteUser(TempCostumers tempCostumer) throws SQLException {
        return false;
    }

    @Override
    public ObservableList<TempCostumers> getAllTempCostumers() throws SQLException {
        return null;
    }

    @Override
    public TempCostumers getTempCostumer(String username) throws SQLException {
        return null;
    }
}
