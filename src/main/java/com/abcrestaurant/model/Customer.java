package com.abcrestaurant.model;

public class Customer {

    private int customerid;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String password;

    // Constructor with all fields
    public Customer(int id, String name, String email, String phone, String address, String password) {
        this.customerid = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.password = password;
    }

    public Customer() {
		// TODO Auto-generated constructor stub
	}

	// Getters and Setters for all fields
    public int getId() { return customerid; }
    public void setId(int id) { this.customerid = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
