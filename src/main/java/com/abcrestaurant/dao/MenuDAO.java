package com.abcrestaurant.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.abcrestaurant.model.Menu;

public class MenuDAO {

    // Method to add a new menu item to the database
    public void addMenuItem(Menu menu) {
        String query = "INSERT INTO menu_items (name, description, price, category) VALUES (?, ?, ?, ?)";
        try (Connection connection = DBConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, menu.getName());
            statement.setString(2, menu.getDescription());
            statement.setDouble(3, menu.getPrice());
            statement.setString(4, menu.getCategory());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to retrieve all menu items from the database
    public List<Menu> getAllMenuItems() {
        List<Menu> menuList = new ArrayList<>();
        String query = "SELECT * FROM menu";
        try (Connection connection = DBConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                double price = resultSet.getDouble("price");
                String category = resultSet.getString("category");
                menuList.add(new Menu(id, name, description, price, category));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menuList;
    }

    // Method to retrieve a menu item by ID
    public Menu getMenuItemById(int id) {
        String query = "SELECT * FROM menu WHERE id = ?";
        try (Connection connection = DBConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String name = resultSet.getString("name");
                    String description = resultSet.getString("description");
                    double price = resultSet.getDouble("price");
                    String category = resultSet.getString("category");
                    return new Menu(id, name, description, price, category);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Method to update a menu item
    public void updateMenuItem(Menu menu) {
        String query = "UPDATE menu SET name = ?, description = ?, price = ?, category = ? WHERE id = ?";
        try (Connection connection = DBConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, menu.getName());
            statement.setString(2, menu.getDescription());
            statement.setDouble(3, menu.getPrice());
            statement.setString(4, menu.getCategory());
            statement.setInt(5, menu.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to delete a menu item by ID
    public void deleteMenuItem(int id) {
        String query = "DELETE FROM menu WHERE id = ?";
        try (Connection connection = DBConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
}
