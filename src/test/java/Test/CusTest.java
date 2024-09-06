package Test;

import static org.junit.Assert.*;
import org.junit.Test;
import com.abcrestaurant.model.Customer;

public class CusTest {

    @Test
    public void testCustomerConstructorWithArgs() {
        int customerId = 1;
        String name = "Hirusha Perera";
        String email = "hirushaperera@gmail.com";
        String phone = "0771236589";
        String address = "No.10 Mainstreet, Kandy";
        String password = "pass1234";

        Customer customer = new Customer(customerId, name, email, phone, address, password);

        assertEquals(customerId, customer.getId());
        assertEquals(name, customer.getName());
        assertEquals(email, customer.getEmail());
        assertEquals(phone, customer.getPhone());
        assertEquals(address, customer.getAddress());
        assertEquals(password, customer.getPassword());
    }

    @Test
    public void testCustomerDefaultConstructorAndSetters() {
        Customer customer = new Customer();

        customer.setId(2);
        customer.setName("Amasha Dissanayake");
        customer.setEmail("amashadissanayake@gmail.com");
        customer.setPhone("0778965412");
        customer.setAddress("No.220, Kandy");
        customer.setPassword("secure1234");

        assertEquals(2, customer.getId());
        assertEquals("Amasha Dissanayake", customer.getName());
        assertEquals("amashadissanayake@gmail.com", customer.getEmail());
        assertEquals("0778965412", customer.getPhone());
        assertEquals("No.220, Kandy", customer.getAddress());
        assertEquals("secure1234", customer.getPassword());
    }

    @Test
    public void testGettersAndSetters() {
        Customer customer = new Customer();

        customer.setId(3);
        customer.setName("Shehara Alwis");
        customer.setEmail("sheharaalwis@gmail.com");
        customer.setPhone("0778523645");
        customer.setAddress("No.54, Peradeniya");
        customer.setPassword("shehara00");

        assertEquals(3, customer.getId());
        assertEquals("Shehara Alwis", customer.getName());
        assertEquals("sheharaalwis@gmail.com", customer.getEmail());
        assertEquals("0778523645", customer.getPhone());
        assertEquals("No.54, Peradeniya", customer.getAddress());
        assertEquals("shehara00", customer.getPassword());
    }

    @Test
    public void testCustomerEmailSetter() {
        Customer customer = new Customer();
        String email = "sanjeewa@gmail.com";

        customer.setEmail(email);

        assertEquals(email, customer.getEmail());
    }

    @Test
    public void testCustomerPasswordSetter() {
        Customer customer = new Customer();
        String password = "updatedPassword123";

        customer.setPassword(password);

        assertEquals(password, customer.getPassword());
    }
}
