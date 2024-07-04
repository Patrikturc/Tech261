package com.sparta.pt;

import com.sparta.pt.database.CustomerDAO;
import com.sparta.pt.database.DatabaseConnection;
import com.sparta.pt.database.DatabaseProperties;

import java.sql.*;
import java.util.Properties;

public class App {


    public static void main(String[] args) {

        DatabaseProperties propertiesLoader = new DatabaseProperties("src/main/resources/mysql.properties");
        Properties properties = propertiesLoader.getProperties();

        DatabaseConnection databaseConnection = new DatabaseConnection(properties);

        CustomerDAO customerDAO = new CustomerDAO(databaseConnection);
        customerDAO.printCustomerByName("Maria Anders");

    }
}
