package com.abcrestaurant.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abcrestaurant.model.Customer;
import com.abcrestaurant.service.CustomerService;

@WebServlet("/registerCustomer")  // Updated to match the form's action URL
public class CustomerController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private CustomerService customerService;

    public void init() throws ServletException {
        customerService = CustomerService.getInstance();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/view/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");  
        String address = request.getParameter("address");  
        String password = request.getParameter("password");

        Customer customer = new Customer(0, password, password, password, password, password);
        customer.setName(name);
        customer.setEmail(email);
        customer.setPhone(phone);  
        customer.setAddress(address);  
        customer.setPassword(password);

        try {
            if (customerService.getCustomerByEmail(email) == null) {
                customerService.addCustomer(customer);
                response.setContentType("text/html");
                response.getWriter().write("<div class='popup' style='display: block;'><span class='popup-content'>Registration successful...</span></div>");
                response.setHeader("Refresh", "3; URL=login.jsp");  // Redirect to login page after 3 seconds
            } else {
                request.setAttribute("errorMessage", "Email already registered.");
                request.getRequestDispatcher("WEB-INF/view/register.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Registration failed. Please try again.");
            request.getRequestDispatcher("WEB-INF/view/register.jsp").forward(request, response);
        }
    }
}
