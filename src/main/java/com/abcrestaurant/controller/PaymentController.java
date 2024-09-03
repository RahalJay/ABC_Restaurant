package com.abcrestaurant.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abcrestaurant.model.Payment;
import com.abcrestaurant.service.PaymentService;

@WebServlet("/processPayment")
public class PaymentController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private PaymentService paymentService;

    public void init() throws ServletException {
        paymentService = PaymentService.getInstance();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        double amount = Double.parseDouble(request.getParameter("amount"));
        String paymentMethod = request.getParameter("paymentMethod");
        Date paymentDate = new Date(customerId); // Current date
        String status = "Completed";

        Payment payment = new Payment(0, customerId, amount, paymentMethod, paymentDate, status);

        paymentService.processPayment(payment);

        response.setContentType("text/html");
        response.getWriter().write("<div class='popup' style='display: block;'><span class='popup-content'>Payment processed successfully...</span></div>");
        response.setHeader("Refresh", "3; URL=paymentSuccess.jsp");  // Redirect to payment success page after 3 seconds
    }
}

