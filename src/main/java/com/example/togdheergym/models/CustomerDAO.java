package com.example.togdheergym.models;

import com.example.togdheergym.interfaces.CostumerModel;
import com.example.togdheergym.objects.Costumers;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomerDAO  implements CostumerModel {
    private PreparedStatement ps;
    private Statement st;
    private SimpleDateFormat df;
    private Costumers costumer = null;

    private int counter;

    Connection connection;


    public CustomerDAO() throws SQLException {
        this.df = new SimpleDateFormat("yyyy-MM-dd");

        connection = getConnection();
        counter = getLimit();
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
      //  System.out.println("Opened database successfully");
        return con;
    }

    @Override
    public void insertCustomer(Costumers costumer) {
        try {
            Connection con = getConnection();
            con.setAutoCommit(false);
            ps = con.prepareStatement("INSERT INTO costumers(first_name, last_name, phone, gander, shift, paid, discount, paidby, image, poxing, who_added)\n" +
                    "VALUES (?,?,?,?,?,?,?,?,?,?,?);\n");

            getPreparedStatements(costumer);
            st = con.createStatement();

            if (costumer.getGender().equalsIgnoreCase("male")) {
                if (st.executeUpdate("UPDATE daily_reports set today_reg=(today_reg+1) ,male=(male+1) WHERE today_date='" + df.format(new Date()) + "'") > 0) {
                    System.out.println("updated by male");
                } else {
                    st.executeUpdate("INSERT into daily_reports(today_reg,male) values(1,1);");
                    System.out.println("Inserted new Value");
                }
            } else if (costumer.getGender().equalsIgnoreCase("female")) {
                if (st.executeUpdate("UPDATE daily_reports set today_reg=(today_reg+1) ,female=(female+1) WHERE today_date='" + df.format(new Date()) + "'") > 0) {
                    System.out.println("updated by female");
                } else {
                    st.executeUpdate("INSERT into daily_reports(today_reg,female) values(1,1);");
                    System.out.println("Inserted new Value");
                }
            }
            con.commit();
            con.close();
            System.out.print("Inserted....");
        } catch (Exception e) {
            e.printStackTrace();

        }
     }

    @Override
    public void updateCustomer(Costumers costumer) {

        try {
            Connection connection = getConnection();
            ps = connection.prepareStatement("UPDATE costumers set first_name=?, last_name=?, phone=?, gander=?, shift=?, paid=?, discount=?, paidby=?, image=?, poxing=?,\n" +
                    "                    who_added=? WHERE costumer_id=" + costumer.getCostumerId());

            getPreparedStatements(costumer);
            ps.close();
            connection.close();
            System.out.println("Costumer updated");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean deleteCustomer(Costumers costumer) throws SQLException {
        Connection connection = getConnection();
        Statement statement = getConnection().createStatement();
        if (statement.execute("DELETE FROM costumers WHERE costumer_id=" + costumer.getCostumerId())) {
            return true;
        }
        connection.close();
        return false;
    }


    @Override
    public ObservableList<Costumers> getAllCustomers() throws SQLException {
        ObservableList<Costumers> getCostumers = FXCollections.observableArrayList();
        Connection connection = getConnection();
        Statement statement = getConnection().createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM costumers");

        while (rs.next()) {
            costumer = new Costumers(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getDouble(7), rs.getDouble(8), rs.getString(9), rs.getString(10), rs.getBoolean(11), rs.getString(12),
                    rs.getString(13), rs.getString(14));
            getCostumers.add(costumer);

        }
        statement.close();
        connection.close();
        rs.close();
        return getCostumers;
    }


    private void getPreparedStatements(Costumers costumer) throws SQLException {
        ps.setString(1, costumer.getFirstName());
        ps.setString(2, costumer.getLastName());
        ps.setString(3, costumer.getPhone());
        ps.setString(4, costumer.getGender());
        ps.setString(5, costumer.getShift());
        ps.setDouble(6, costumer.getPaid());
        ps.setDouble(7, costumer.getDiscount());
        ps.setString(8, costumer.getPaidBy());
        ps.setString(9, costumer.getImage());
        ps.setBoolean(10, costumer.isPoxing());
        ps.setString(11, costumer.getWhoAdded());
        ps.executeUpdate();
    }

    public int getLimit() throws SQLException {
        int counter = 0;
        Connection connection = getConnection();
        Statement statement = getConnection().createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM costumers");
        while (rs.next()) {
            counter++;
        }
        connection.close();
        rs.close();
        statement.close();
        return counter;
    }


}
