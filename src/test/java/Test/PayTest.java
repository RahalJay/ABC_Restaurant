package Test;

import static org.junit.Assert.*;
import org.junit.Test;
import com.abcrestaurant.model.Payment;
import java.sql.Date;

public class PayTest {

    @Test
    public void testPaymentConstructorWithArgs() {
        int paymentId = 1;
        int customerId = 100;
        double amount = 2500.00;
        String paymentMethod = "Credit Card";
        Date paymentDate = new Date(System.currentTimeMillis()); 
        String status = "Completed";

        Payment payment = new Payment(paymentId, customerId, amount, paymentMethod, paymentDate, status);

        assertEquals(paymentId, payment.getPaymentId());
        assertEquals(customerId, payment.getCustomerId());
        assertEquals(amount, payment.getAmount(), 0.01); 
        assertEquals(paymentMethod, payment.getPaymentMethod());
        assertEquals(paymentDate, payment.getPaymentDate());
        assertEquals(status, payment.getStatus());
    }

    @Test
    public void testPaymentDefaultConstructorAndSetters() {
        Payment payment = new Payment(0, 0, 0.0, null, null, null); 

        payment.setPaymentId(2);
        payment.setCustomerId(101);
        payment.setAmount(3500.00);
        payment.setPaymentMethod("PayPal");
        payment.setPaymentDate(new Date(System.currentTimeMillis()));
        payment.setStatus("Pending");

        assertEquals(2, payment.getPaymentId());
        assertEquals(101, payment.getCustomerId());
        assertEquals(3500.00, payment.getAmount(), 0.01);
        assertEquals("PayPal", payment.getPaymentMethod());
        assertEquals(new Date(System.currentTimeMillis()), payment.getPaymentDate());
        assertEquals("Pending", payment.getStatus());
    }

    @Test
    public void testGettersAndSetters() {
        Payment payment = new Payment(0, 0, 0.0, null, null, null); 

        payment.setPaymentId(3);
        payment.setCustomerId(102);
        payment.setAmount(1750.00);
        payment.setPaymentMethod("Bank Transfer");
        payment.setPaymentDate(new Date(System.currentTimeMillis()));
        payment.setStatus("Failed");

        assertEquals(3, payment.getPaymentId());
        assertEquals(102, payment.getCustomerId());
        assertEquals(1750.00, payment.getAmount(), 0.01);
        assertEquals("Bank Transfer", payment.getPaymentMethod());
        assertEquals(new Date(System.currentTimeMillis()), payment.getPaymentDate());
        assertEquals("Failed", payment.getStatus());
    }

    @Test
    public void testPaymentMethodSetter() {
        Payment payment = new Payment(0, 0, 0.0, null, null, null);
        String paymentMethod = "Cash";

        payment.setPaymentMethod(paymentMethod);

        assertEquals(paymentMethod, payment.getPaymentMethod());
    }

    @Test
    public void testPaymentStatusSetter() {
        Payment payment = new Payment(0, 0, 0.0, null, null, null);
        String status = "Refunded";

        payment.setStatus(status);

        assertEquals(status, payment.getStatus());
    }
}
