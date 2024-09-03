package com.abcrestaurant.service;

import java.util.List;

import com.abcrestaurant.dao.PaymentDAO;
import com.abcrestaurant.model.Payment;

public class PaymentService {

    private static PaymentService instance;
    private PaymentDAO paymentDAO;

    private PaymentService() {
        this.paymentDAO = new PaymentDAO();
    }

    public static PaymentService getInstance() {
        if (instance == null) {
            synchronized (PaymentService.class) {
                if (instance == null) {
                    instance = new PaymentService();
                }
            }
        }
        return instance;
    }

    // Method to process a payment
    public void processPayment(Payment payment) {
        paymentDAO.addPayment(payment);
    }

    // Method to get payments by customer ID
    public List<Payment> getPaymentsByCustomerId(int customerId) {
        return paymentDAO.getPaymentsByCustomerId(customerId);
    }
	
}
