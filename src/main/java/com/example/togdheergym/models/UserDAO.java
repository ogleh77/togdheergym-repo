package com.example.togdheergym.models;

import com.example.togdheergym.interfaces.UsersModel;
import com.example.togdheergym.objects.Users;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class UserDAO implements UsersModel {
    public Connection getConnection() {
        Connection con = null;

        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:src/database/database.db");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        //System.out.println("Opened database successfully");
        return con;
    }

    private Connection connection = getConnection();


    @Override
    public void insertUser(Users user) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("INSERT INTO users(first_name, last_name, phone, gander, shift, username, password, image, is_admin)\n" +
                "VALUES (?,?,?,?,?,?,?,?,?);\n");
        getPreparedStatement(user, ps);
        System.out.println("Saved");
        connection.close();
        ps.close();
    }


    @Override
    public void updateUser(Users user) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("UPDATE users set first_name=?,last_name=?,phone=?,gander=?,shift=?,username=?,password=?,image=?,is_admin=?" +
                " WHERE user_id=" + user.getUserId());
        getPreparedStatement(user, ps);
        System.out.println("Updated.....");
        connection.close();
        ps.close();
    }

    @Override
    public boolean deleteUser(Users user) throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("DELETE FROM users WHERE user_id=" + user.getUserId());
        statement.close();
        return false;
    }

    @Override
    public ObservableList<Users> getAllUsers() throws SQLException {
        Users user = null;
        ObservableList<Users> users = FXCollections.observableArrayList();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM users");
        while (rs.next()) {
            user = new Users(rs.getInt(1), rs.getString(2), rs.getString(3),
                    rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),
                    rs.getString(8), rs.getString(9), rs.getBoolean(10));
            users.add(user);
        }
        statement.close();
        rs.close();
        statement.close();
        return users;
    }

    @Override
    public Users getUser(String username) throws SQLException {
        Users user = null;
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM users WHERE username='" + username + "';");
        while (rs.next()) {
            user = new Users(rs.getInt(1), rs.getString(2), rs.getString(3),
                    rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),
                    rs.getString(8), rs.getString(9), rs.getBoolean(10));
        }
        statement.close();
        rs.close();
        statement.close();
        return user;
    }

    private void getPreparedStatement(Users user, PreparedStatement ps) throws SQLException {
        ps.setString(1, user.getFirstName());
        ps.setString(2, user.getLastName());
        ps.setString(3, user.getPhone());
        ps.setString(4, user.getGender());
        ps.setString(5, user.getShift());
        ps.setString(6, user.getUsername());
        ps.setString(7, user.getPassword());
        ps.setString(8, user.getImage());
        ps.setBoolean(9, user.isAdmin());
        ps.executeUpdate();
    }

}
