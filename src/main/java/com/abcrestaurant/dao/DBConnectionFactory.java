package com.abcrestaurant.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionFactory {
	
	 public static Connection getConnection() {
	        return DBConnection.getInstance().getConnection();
	    }

}





