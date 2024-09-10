package com.abcrestaurant.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.abcrestaurant.model.Query;

public class QueryDAO {

    public void addQuery(Query query) throws SQLException {
        String queryStr = "INSERT INTO query (customer_id, query_type, query_description, status, response) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DBConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(queryStr)) {
            statement.setInt(1, query.getCustomerId());
            statement.setString(2, query.getQueryType());
            statement.setString(3, query.getQueryDescription());
            statement.setString(4, query.getStatus());
            statement.setString(5, query.getResponse());
            statement.executeUpdate();
        }
    }

    public Query getQueryById(int queryId) throws SQLException {
        String queryStr = "SELECT * FROM query WHERE query_id = ?";
        try (Connection connection = DBConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(queryStr)) {
            statement.setInt(1, queryId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int customerId = resultSet.getInt("customer_id");
                    String queryType = resultSet.getString("query_type");
                    String queryDescription = resultSet.getString("query_description");
                    String status = resultSet.getString("status");
                    String response = resultSet.getString("response");
                    return new Query(queryId, customerId, queryType, queryDescription, status, response);
                }
            }
        }
        return null;
    }

    public void updateQueryResponse(int queryId, String response, String status) throws SQLException {
        String queryStr = "UPDATE query SET response = ?, status = ? WHERE query_id = ?";
        try (Connection connection = DBConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(queryStr)) {
            statement.setString(1, response);
            statement.setString(2, status);
            statement.setInt(3, queryId);
            statement.executeUpdate();
        }
    }
	
}
