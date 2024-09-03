package com.abcrestaurant.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.abcrestaurant.model.Customer;

public class CustomerDAO {
	
    // Method to add a new customer to the database
    public void addCustomer(Customer customer) {
        // Updated SQL query to include phone and address fields
        String query = "INSERT INTO customer (name, email, phone, address, password) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DBConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, customer.getName());
            statement.setString(2, customer.getEmail());
            statement.setString(3, customer.getPhone());
            statement.setString(4, customer.getAddress());
            statement.setString(5, customer.getPassword());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to retrieve a customer by email
    public Customer getCustomerByEmail(String email) throws SQLException {
        String query = "SELECT * FROM customer WHERE email = ?";
        try (Connection connection = DBConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, email);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("customer_id");
                    String name = resultSet.getString("name");
                    String phone = resultSet.getString("phone");
                    String address = resultSet.getString("address");
                    String password = resultSet.getString("password");
                    return new Customer(id, name, email, phone, address, password);
                }
            }
            
            catch (SQLException e) {
                e.printStackTrace();
                throw e; // Throw the exception to the caller to handle it appropriately
            }
        }
        return null;
    }

}
