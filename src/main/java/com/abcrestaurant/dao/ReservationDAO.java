package com.abcrestaurant.dao;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.abcrestaurant.model.Reservation;

public class ReservationDAO {

    public void addReservation(Reservation reservation) {
        String query = "INSERT INTO reservation (customer_id, reservation_date, reservation_time, reservation_type) VALUES (?, ?, ?, ?)";
        try (Connection connection = DBConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, reservation.getCustomerId());
            statement.setDate(2, new java.sql.Date(reservation.getReservationDate().getTime()));
            statement.setString(3, reservation.getReservationTime());
            statement.setString(4, reservation.getReservationType());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Reservation> getAllReservations() {
        List<Reservation> reservations = new ArrayList<>();
        String query = "SELECT * FROM reservation";
        try (Connection connection = DBConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int customerId = resultSet.getInt("customer_id");
                Date reservationDate = resultSet.getDate("reservation_date");
                String reservationTime = resultSet.getString("reservation_time");
                String reservationType = resultSet.getString("reservation_type");
                reservations.add(new Reservation(id, customerId, reservationDate, reservationTime, reservationType));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reservations;
    }

    public List<Reservation> getReservationsByCustomerId(int customerId) {
        List<Reservation> reservations = new ArrayList<>();
        String query = "SELECT * FROM reservation WHERE customer_id = ?";
        try (Connection connection = DBConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, customerId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    Date reservationDate = resultSet.getDate("reservation_date");
                    String reservationTime = resultSet.getString("reservation_time");
                    String reservationType = resultSet.getString("reservation_type");
                    reservations.add(new Reservation(id, customerId, reservationDate, reservationTime, reservationType));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reservations;
    }
	
}
