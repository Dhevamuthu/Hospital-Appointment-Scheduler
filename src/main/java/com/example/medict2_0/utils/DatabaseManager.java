package com.example.medict2_0.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    private DatabaseManager() {

    }
    private static Connection dbConnection;

    public static Connection getDbInstance() throws SQLException {
        if (dbConnection == null) {
            dbConnection = establishConnection();
        }
        return dbConnection;
    }

    private static Connection establishConnection() throws SQLException {
        // todo: Establish and return connection;
        Connection con;
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/medict","root","12345");
    }
}
