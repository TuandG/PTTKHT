package com.example.libman.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class  DAO {
    protected Connection con;
    public DAO() {
        String username = "admin";
        String password = "admin";
        String url = "jdbc:postgresql://localhost:5432/libman";
        try{
            Class.forName("org.postgresql.Driver");
            this.con = DriverManager.getConnection(url, username, password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
