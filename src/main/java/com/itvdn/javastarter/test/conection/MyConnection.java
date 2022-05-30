package com.itvdn.javastarter.test.conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/carshop";
    private static final String USER = "bestuser";
    private static final String PASSWORD= "bestuser";

    public static Connection getConnection() {
        //System.setProperty("jdbc.driver","org.postgres.Driver");
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            return connection;
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
