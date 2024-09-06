package com.abcrestaurant.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.abcrestaurant.model.Payment;

public class PaymentDAO {

    public void addPayment(Payment payment) {
        String query = "INSERT INTO payment (customer_id, amount, payment_method, payment_date, status) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DBConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, payment.getCustomerId());
            statement.setDouble(2, payment.getAmount());
            statement.setString(3, payment.getPaymentMethod());
            statement.setDate(4, new java.sql.Date(payment.getPaymentDate().getTime()));
            statement.setString(5, payment.getStatus());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Payment> getPaymentsByCustomerId(int customerId) {
        List<Payment> payments = new ArrayList<>();
        String query = "SELECT * FROM payment WHERE customer_id = ?";
        try (Connection connection = DBConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, customerId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int paymentId = resultSet.getInt("payment_id");
                    double amount = resultSet.getDouble("amount");
                    String paymentMethod = resultSet.getString("payment_method");
                    java.util.Date paymentDate = new java.util.Date(resultSet.getDate("payment_date").getTime());
                    String status = resultSet.getString("status");

                    Payment payment = new Payment(paymentId, customerId, amount, paymentMethod, paymentDate, status);
                    payments.add(payment);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return payments;
    }
	
}
