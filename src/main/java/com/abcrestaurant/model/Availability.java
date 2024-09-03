package com.abcrestaurant.model;

import java.sql.Date;

public class Availability {

    private int id;
    private java.util.Date date;
    private String timeSlot;
    private int availableSlots; // Number of available slots (tables or time slots)
    private String serviceType; // e.g., 'dine-in', 'delivery', etc.

    // Constructor
    public Availability(int id, java.util.Date date2, String timeSlot, int availableSlots, String serviceType) {
        this.id = id;
        this.date = date2;
        this.timeSlot = timeSlot;
        this.availableSlots = availableSlots;
        this.serviceType = serviceType;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public java.util.Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    public String getTimeSlot() { return timeSlot; }
    public void setTimeSlot(String timeSlot) { this.timeSlot = timeSlot; }

    public int getAvailableSlots() { return availableSlots; }
    public void setAvailableSlots(int availableSlots) { this.availableSlots = availableSlots; }

    public String getServiceType() { return serviceType; }
    public void setServiceType(String serviceType) { this.serviceType = serviceType; }
	
}
