package com.abcrestaurant.service;

import java.util.List;

import com.abcrestaurant.dao.ReservationDAO;
import com.abcrestaurant.model.Reservation;

public class ReservationService {

    private static ReservationService instance;
    private ReservationDAO reservationDAO;

    private ReservationService() {
        this.reservationDAO = new ReservationDAO();
    }

    public static ReservationService getInstance() {
        if (instance == null) {
            synchronized (ReservationService.class) {
                if (instance == null) {
                    instance = new ReservationService();
                }
            }
        }
        return instance;
    }

    public void addReservation(int customerId, java.util.Date reservationDate, String reservationTime, String reservationType) {
        Reservation reservation = new Reservation(0, customerId, reservationDate, reservationTime, reservationType);
        reservationDAO.addReservation(reservation);
    }

    public List<Reservation> getAllReservations() {
        return reservationDAO.getAllReservations();
    }

    public List<Reservation> getReservationsByCustomerId(int customerId) {
        return reservationDAO.getReservationsByCustomerId(customerId);
    }
	
}
