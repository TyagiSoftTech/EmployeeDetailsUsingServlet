package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static Connection getConnection() throws IllegalAccessException, InstantiationException, SQLException {
        try {
            Connection con = null;
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            // create a connection to the database

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo1?useSSL=false", "root", "root");
            // System.out.println("Connection established");

            return con;
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }
}
