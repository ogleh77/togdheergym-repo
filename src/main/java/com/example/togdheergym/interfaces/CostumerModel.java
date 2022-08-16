package com.example.togdheergym.interfaces;

import com.example.togdheergym.objects.Costumers;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface CostumerModel {
    void insertCustomer(Costumers costumer);

    void updateCustomer(Costumers costumer);

    boolean deleteCustomer(Costumers costumer) throws SQLException;
 
    ObservableList<Costumers> getAllCustomers() throws SQLException;


}
