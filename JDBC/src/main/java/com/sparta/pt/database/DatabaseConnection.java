package com.sparta.pt.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
    private final Properties properties;

    public DatabaseConnection(Properties properties) {
        this.properties = properties;
    }

    public Connection getConnection() throws SQLException {
            return DriverManager.getConnection(
                    properties.getProperty("url"),
                    properties.getProperty("username"),
                    properties.getProperty("password")
            );
    }
}
