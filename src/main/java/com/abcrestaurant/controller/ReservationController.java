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

import com.abcrestaurant.model.Reservation;
import com.abcrestaurant.service.ReservationService;

@WebServlet("/reservation")
	public class ReservationController extends HttpServlet {
	    private static final long serialVersionUID = 1L;

	    private ReservationService reservationService;

	    public void init() throws ServletException {
	        reservationService = ReservationService.getInstance();
	    }

	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        List<Reservation> reservations = reservationService.getAllReservations();
	        request.setAttribute("reservations", reservations);
	        request.getRequestDispatcher("/reservation.js").forward(request, response);
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        int customerId = Integer.parseInt(request.getParameter("customerId"));
	        String dateStr = request.getParameter("reservationDate");
	        String time = request.getParameter("reservationTime");
	        String type = request.getParameter("reservationType");

	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        try {
	            Date reservationDate = dateFormat.parse(dateStr);
	            reservationService.addReservation(customerId, reservationDate, time, type);
	            response.setContentType("text/html");
	            response.getWriter().write("<div class='popup' style='display: block;'><span class='popup-content'>Reservation successful...</span></div>");
	            response.setHeader("Refresh", "3; URL=reservation.js"); 
	        } catch (ParseException e) {
	            e.printStackTrace();
	            response.setContentType("text/html");
	            response.getWriter().write("<div class='popup' style='display: block;'><span class='popup-content'>Reservation failed. Please try again.</span></div>");
	            response.setHeader("Refresh", "3; URL=reservation.js");
	        }
	    }
	}
	
