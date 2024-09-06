package com.abcrestaurant.controller;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abcrestaurant.model.Staff;
import com.abcrestaurant.service.StaffService;

@WebServlet("/staffLogin")
public class StaffController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private StaffService staffService;

    public void init() throws ServletException {
        staffService = StaffService.getInstance();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/staffLogin.js").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            Staff staff = staffService.getStaffByEmail(email);
            if (staff != null && staff.getPassword().equals(password)) {
                response.sendRedirect("staffDashboard.js");
            } else {
                request.setAttribute("errorMessage", "Invalid email or password.");
                request.getRequestDispatcher("WEB-INF/view/staffLogin.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Login failed. Please try again.");
            request.getRequestDispatcher("/staffLogin.js").forward(request, response);
        }
    }
}
