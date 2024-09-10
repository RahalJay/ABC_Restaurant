package com.abcrestaurant.service;

import java.sql.SQLException;

import com.abcrestaurant.dao.QueryDAO;
import com.abcrestaurant.model.Query;

public class QueryService {

    private static QueryService instance;
    private QueryDAO queryDAO;

    private QueryService() {
        this.queryDAO = new QueryDAO();
    }

    public static QueryService getInstance() {
        if (instance == null) {
            synchronized (QueryService.class) {
                if (instance == null) {
                    instance = new QueryService();
                }
            }
        }
        return instance;
    }

    public void submitQuery(Query query) throws SQLException {
        queryDAO.addQuery(query);
    }

    public Query getQueryById(int queryId) throws SQLException {
        return queryDAO.getQueryById(queryId);
    }

    public void respondToQuery(int queryId, String response, String status) throws SQLException {
        queryDAO.updateQueryResponse(queryId, response, status);
    }
	
}
