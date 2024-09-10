package com.abcrestaurant.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.abcrestaurant.model.Staff;

public class StaffDAO {

    public void addStaff(Staff staff) {
        String query = "INSERT INTO staff (name, email, phone, role, password) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DBConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, staff.getName());
            statement.setString(2, staff.getEmail());
            statement.setString(3, staff.getPhone());
            statement.setString(4, staff.getRole());
            statement.setString(5, staff.getPassword());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Staff getStaffByEmail(String email) throws SQLException {
        String query = "SELECT * FROM staff WHERE email = ?";
        try (Connection connection = DBConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, email);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("staff_id");
                    String name = resultSet.getString("name");
                    String phone = resultSet.getString("phone");
                    String role = resultSet.getString("role");
                    String password = resultSet.getString("password");
                    return new Staff(id, name, email, phone, role, password);
                }
            }
        }
        return null;
    }
	
}
