package com.abcrestaurant.controller;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abcrestaurant.model.Query;
import com.abcrestaurant.service.QueryService;

@WebServlet("/query") 
	public class QueryController extends HttpServlet {
	    private static final long serialVersionUID = 1L;

	    private QueryService queryService;

	    public void init() throws ServletException {
	        queryService = QueryService.getInstance();
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        int customerId = Integer.parseInt(request.getParameter("customerId"));
	        String queryType = request.getParameter("queryType");
	        String queryDescription = request.getParameter("queryDescription");

	        Query query = new Query(0, customerId, queryType, queryDescription, "Pending", null);

	        try {
	            queryService.submitQuery(query);
	            response.setContentType("text/html");
	            response.getWriter().write("<div class='popup' style='display: block;'><span class='popup-content'>Query submitted successfully...</span></div>");
	            response.setHeader("Refresh", "3; URL=query.js");  
	        } catch (SQLException e) {
	            e.printStackTrace();
	            request.setAttribute("errorMessage", "Query submission failed. Please try again.");
	            request.getRequestDispatcher("/query.js").forward(request, response);
	        }
	    }
	}
	

