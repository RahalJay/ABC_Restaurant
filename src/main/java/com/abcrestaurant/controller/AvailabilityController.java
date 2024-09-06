package com.abcrestaurant.controller;

import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abcrestaurant.model.Availability;
import com.abcrestaurant.service.AvailabilityService;

@WebServlet("/checkAvailability")
public class AvailabilityController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private AvailabilityService availabilityService;

    public void init() throws ServletException {
        availabilityService = AvailabilityService.getInstance();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/checkAvailability.js").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dateStr = request.getParameter("date");
        String serviceType = request.getParameter("serviceType");

        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
            List<Availability> availableSlots = availabilityService.checkAvailability(date, serviceType);
            request.setAttribute("availableSlots", availableSlots);
            request.getRequestDispatcher("/checkAvailability.js").forward(request, response);
        } catch (ParseException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Invalid date format.");
            request.getRequestDispatcher("/checkAvailability.js").forward(request, response);
        }
    }
    }
