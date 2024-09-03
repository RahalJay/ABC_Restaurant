package com.abcrestaurant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.abcrestaurant.model.Availability;

public class AvailabilityDAO {

    // Method to get available slots based on date, time, and service type
    public List<Availability> getAvailability1(java.util.Date date, String serviceType) {
        List<Availability> availabilityList = new ArrayList<>();
        String query = "SELECT * FROM availability WHERE date = ? AND service_type = ?";

        try (Connection connection = DBConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setDate(1, new java.sql.Date(date.getTime()));
            statement.setString(2, serviceType);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String timeSlot = resultSet.getString("time_slot");
                    int availableSlots = resultSet.getInt("available_slots");
                    
                    Availability availability = new Availability(id, date, timeSlot, availableSlots, serviceType);
                    availabilityList.add(availability);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return availabilityList;
    }

	public List<Availability> getAvailability(java.util.Date date, String serviceType) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
