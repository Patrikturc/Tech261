package com.sparta.pt.database;

import java.sql.*;

public class CustomerDAO {
    private final DatabaseConnection databaseConnection;

    public CustomerDAO(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    public void printCustomerByName(String contactName) {
        String query = "SELECT * FROM northwind.customers WHERE ContactName = ?";
        try (Connection connection = databaseConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, contactName);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String customerID = resultSet.getString("CustomerID");
                String companyName = resultSet.getString("CompanyName");
                String contactNameResult = resultSet.getString("ContactName");

                System.out.printf("CustomerID: %s, CompanyName: %s, ContactName: %s%n",
                        customerID, companyName, contactNameResult);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to execute query for customer by name", e);
        }
    }

    public void printAllCustomers() {
        try (Connection connection = databaseConnection.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM northwind.customers");
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1)); //Data type and column index must be correct
                System.out.println(resultSet.getString(2)); //Data type and column index must be correct
                System.out.println(resultSet.getString(3)); //Data type and column index must be correct
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to execute query for all customers", e);
        }
    }
}