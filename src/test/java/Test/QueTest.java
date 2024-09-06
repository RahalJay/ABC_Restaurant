package Test;

import static org.junit.Assert.*;
import org.junit.Test;
import com.abcrestaurant.model.Query;

public class QueTest {

    @Test
    public void testQueryConstructorWithArgs() {
        int queryId = 1;
        int customerId = 100;
        String queryType = "Service";
        String queryDescription = "Request for additional service.";
        String status = "Pending";
        String response = "No response yet";

        Query query = new Query(queryId, customerId, queryType, queryDescription, status, response);

        assertEquals(queryId, query.getQueryId());
        assertEquals(customerId, query.getCustomerId());
        assertEquals(queryType, query.getQueryType());
        assertEquals(queryDescription, query.getQueryDescription());
        assertEquals(status, query.getStatus());
        assertEquals(response, query.getResponse());
    }

    @Test
    public void testQueryDefaultConstructorAndSetters() {
        Query query = new Query(0, 0, null, null, null, null); 

        query.setQueryId(2);
        query.setCustomerId(101);
        query.setQueryType("Reservation");
        query.setQueryDescription("Booking request for a large group.");
        query.setStatus("Pending");
        query.setResponse("Awaiting staff response");

        assertEquals(2, query.getQueryId());
        assertEquals(101, query.getCustomerId());
        assertEquals("Reservation", query.getQueryType());
        assertEquals("Booking request for a large group.", query.getQueryDescription());
        assertEquals("Pending", query.getStatus());
        assertEquals("Awaiting staff response", query.getResponse());
    }

    @Test
    public void testGettersAndSetters() {
        Query query = new Query(0, 0, null, null, null, null); 

        query.setQueryId(3);
        query.setCustomerId(102);
        query.setQueryType("Service");
        query.setQueryDescription("Inquiry about service options.");
        query.setStatus("Responded");
        query.setResponse("Response provided to the customer.");

        assertEquals(3, query.getQueryId());
        assertEquals(102, query.getCustomerId());
        assertEquals("Service", query.getQueryType());
        assertEquals("Inquiry about service options.", query.getQueryDescription());
        assertEquals("Responded", query.getStatus());
        assertEquals("Response provided to the customer.", query.getResponse());
    }

    @Test
    public void testQueryTypeSetter() {
        Query query = new Query(0, 0, null, null, null, null);
        String queryType = "Complaint";

        query.setQueryType(queryType);

        assertEquals(queryType, query.getQueryType());
    }

    @Test
    public void testQueryResponseSetter() {
        Query query = new Query(0, 0, null, null, null, null);
        String response = "Issue resolved.";

        query.setResponse(response);

        assertEquals(response, query.getResponse());
    }
}
