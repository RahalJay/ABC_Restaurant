package com.abcrestaurant.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
    // Database connection details for the ABC Restaurant system
    private static final String DB_URL = "jdbc:mysql://localhost:3306/abc_restaurant"; // Update to your database URL
    private static final String DB_USER = "root"; // Update to your database username
    private static final String DB_PASSWORD = "asus123"; // Update to your database password

    private static DBConnection instance;  // Singleton instance
    private Connection connection;  // Database connection object

    // Private constructor to prevent instantiation from other classes
    private DBConnection() {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish the connection using the provided URL, username, and password
            this.connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();  // Handle any exceptions by printing the stack trace
        }
    }

    /**
     * Returns the singleton instance of DBConnection.
     * Initializes the instance if it does not already exist.
     *
     * @return instance of DBConnection
     */
    public static DBConnection getInstance() {
        if (instance == null) {
            synchronized (DBConnection.class) { // Synchronize to prevent multi-threading issues
                if (instance == null) {
                    instance = new DBConnection();  // Instantiate the singleton instance
                }
            }
        }
        return instance;
    }

    /**
     * Returns the database connection object.
     *
     * @return connection object to interact with the database
     */
    public Connection getConnection() {
        return connection;
    }

}
