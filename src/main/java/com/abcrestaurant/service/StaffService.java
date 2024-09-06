package com.abcrestaurant.service;

import java.sql.SQLException;

import com.abcrestaurant.dao.StaffDAO;
import com.abcrestaurant.model.Staff;

public class StaffService {

    private static StaffService instance;
    private StaffDAO staffDAO;

    private StaffService() {
        this.staffDAO = new StaffDAO();
    }

    public static StaffService getInstance() {
        if (instance == null) {
            synchronized (StaffService.class) {
                if (instance == null) {
                    instance = new StaffService();
                }
            }
        }
        return instance;
    }

    public void registerStaff(String name, String email, String phone, String role, String password) {
        // Create a new Staff object
        Staff staff = new Staff(0, name, email, phone, role, password);
        
        // Add the new staff using DAO
        staffDAO.addStaff(staff);
    }

    public Staff getStaffByEmail(String email) throws SQLException {
        return staffDAO.getStaffByEmail(email);
    }
	
}
