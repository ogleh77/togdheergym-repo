package com.example.togdheergym.models;

import com.example.togdheergym.objects.Costumers;
import com.example.togdheergym.objects.TempCostumers;
import com.example.togdheergym.objects.Users;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Model extends Task<Void> {
    private CustomerDAO customerDAO;
    private UserDAO userDAO;
    private Connection connection;
    private Statement statement;
    private SimpleDateFormat df;
    private ObservableList<Costumers> activeCostumers;
    private ObservableList<Costumers> outdateCostumers;

    private int counter = 0;

    public Model() throws SQLException {
        this.df = new SimpleDateFormat("yyyy-MM-dd");
        connection = getConnection();
        customerDAO = new CustomerDAO();
        userDAO = new UserDAO();
        activeCostumers = FXCollections.observableArrayList();
        outdateCostumers = FXCollections.observableArrayList();
        counter = customerDAO.getLimit();
    }

    @Override
    protected Void call() throws Exception {
        Costumers costumer = null;
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM costumers");
        int i = 0;
        while (rs.next()) {
            i++;
            Thread.sleep(1000);
            costumer = new Costumers(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getDouble(7), rs.getDouble(8), rs.getString(9), rs.getString(10), rs.getBoolean(11), rs.getString(12),
                    rs.getString(13), rs.getString(14));
            if (costumer.getExpDate().compareTo(df.format(new Date())) > 0) {
                activeCostumers.add(costumer);
            } else if (costumer.getExpDate().compareTo(df.format(new Date())) < 0) {
                outdateCostumers.add(costumer);
            }
            updateProgress(i, counter);
            updateMessage(i + " " + counter);


        }
        return null;
    }

    public CustomerDAO getCustomerDAO() {
        return customerDAO;
    }

    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public ObservableList<Costumers> getActiveCostumers() {
        return activeCostumers;
    }

    public void setActiveCostumers(ObservableList<Costumers> activeCostumers) {
        this.activeCostumers = activeCostumers;
    }

    public ObservableList<Costumers> getOutdateCostumers() {
        return outdateCostumers;
    }

    public void setOutdateCostumers(ObservableList<Costumers> outdateCostumers) {
        this.outdateCostumers = outdateCostumers;
    }

    public Connection getConnection() {
        Connection con = null;

        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:src/database/database.db");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
        return con;
    }

}
