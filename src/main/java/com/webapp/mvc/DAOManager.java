package com.webapp.mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DAOManager {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase"; // A changer psk c'est un exemple
    private static final String DB_USERNAME = "username";
    private static final String DB_PASSWORD = "password";

    private Connection connection;
    private static DAOManager instance;

    public static DAOManager getInstance() {
        if (instance == null) {
            synchronized (DAOManager.class) {
                if (instance == null) {
                    instance = new DAOManager();
                }
            }
        }
        return instance;
    }
    
    public DAOManager() {
        return;
        /*try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle connection error
        }*/
    }

    public Connection getConnection() {
        return connection;
    }

    public void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle closing error
        }
    }
}
