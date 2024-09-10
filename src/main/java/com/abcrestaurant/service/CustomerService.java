package com.abcrestaurant.service;

import java.sql.SQLException;

import com.abcrestaurant.dao.CustomerDAO;
import com.abcrestaurant.model.Customer;

public class CustomerService {
	
    private static CustomerService instance;
    private CustomerDAO customerDAO;

    private CustomerService() {
        this.customerDAO = new CustomerDAO();
    }

    public static CustomerService getInstance() {
        if (instance == null) {
            synchronized (CustomerService.class) {
                if (instance == null) {
                    instance = new CustomerService();
                }
            }
        }
        return instance;
    }

    public void registerCustomer(String name, String email, String phone, String address, String password) {

        Customer customer = new Customer(0, password, password, password, password, password);
        customer.setName(name);
        customer.setEmail(email);
        customer.setPhone(phone);
        customer.setAddress(address);
        customer.setPassword(password);
        
        customerDAO.addCustomer(customer);
    }

    public Customer getCustomerByEmail(String email) throws SQLException {
        return customerDAO.getCustomerByEmail(email);
    }

	public void addCustomer(Customer customer) {
		
	}

}



