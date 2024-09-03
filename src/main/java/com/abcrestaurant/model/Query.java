package com.abcrestaurant.model;

public class Query {

    private int queryId;
    private int customerId;
    private String queryType;  // e.g., "Service", "Reservation"
    private String queryDescription;
    private String status;     // e.g., "Pending", "Responded"
    private String response;   // To store the response from the restaurant staff

    // Constructor with all fields
    public Query(int queryId, int customerId, String queryType, String queryDescription, String status, String response) {
        this.queryId = queryId;
        this.customerId = customerId;
        this.queryType = queryType;
        this.queryDescription = queryDescription;
        this.status = status;
        this.response = response;
    }

    // Getters and Setters for all fields
    public int getQueryId() { return queryId; }
    public void setQueryId(int queryId) { this.queryId = queryId; }

    public int getCustomerId() { return customerId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }

    public String getQueryType() { return queryType; }
    public void setQueryType(String queryType) { this.queryType = queryType; }

    public String getQueryDescription() { return queryDescription; }
    public void setQueryDescription(String queryDescription) { this.queryDescription = queryDescription; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getResponse() { return response; }
    public void setResponse(String response) { this.response = response; }
	
}
