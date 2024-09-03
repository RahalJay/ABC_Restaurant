package com.abcrestaurant.model;

import java.sql.Date;

public class Reservation {

    private int id;
    private int customerId;
    private java.util.Date reservationDate;
    private String reservationTime;
    private String reservationType; // e.g., 'dine-in' or 'delivery'

    // Constructor with all fields
    public Reservation(int id, int customerId, java.util.Date reservationDate2, String reservationTime, String reservationType) {
        this.id = id;
        this.customerId = customerId;
        this.reservationDate = reservationDate2;
        this.reservationTime = reservationTime;
        this.reservationType = reservationType;
    }

    // Getters and Setters for all fields
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getCustomerId() { return customerId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }

    public Date getReservationDate() { return (Date) reservationDate; }
    public void setReservationDate(Date reservationDate) { this.reservationDate = reservationDate; }

    public String getReservationTime() { return reservationTime; }
    public void setReservationTime(String reservationTime) { this.reservationTime = reservationTime; }

    public String getReservationType() { return reservationType; }
    public void setReservationType(String reservationType) { this.reservationType = reservationType; }
	
}
