package com.abcrestaurant.service;

import java.util.List;

import com.abcrestaurant.dao.AvailabilityDAO;
import com.abcrestaurant.model.Availability;

public class AvailabilityService {

    private static AvailabilityService instance;
    private AvailabilityDAO availabilityDAO;

    private AvailabilityService() {
        this.availabilityDAO = new AvailabilityDAO();
    }

    public static AvailabilityService getInstance() {
        if (instance == null) {
            synchronized (AvailabilityService.class) {
                if (instance == null) {
                    instance = new AvailabilityService();
                }
            }
        }
        return instance;
    }

    public List<Availability> checkAvailability1(java.util.Date date, String serviceType) {
        return availabilityDAO.getAvailability(date, serviceType);
    }

	public List<Availability> checkAvailability(java.util.Date date, String serviceType) {
		return null;
	}

	
}
