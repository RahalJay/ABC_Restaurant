package Test;

import static org.junit.Assert.*;
import org.junit.Test;
import com.abcrestaurant.model.Staff;

public class StaTest {

    @Test
    public void testStaffConstructorWithArgs() {
        int id = 1;
        String name = "Kalana Senanayake";
        String email = "kalanasenanayake@gmail.com";
        String phone = "0771234567";
        String role = "Manager";
        String password = "kanala0189";

        Staff staff = new Staff(id, name, email, phone, role, password);

        assertEquals(id, staff.getId());
        assertEquals(name, staff.getName());
        assertEquals(email, staff.getEmail());
        assertEquals(phone, staff.getPhone());
        assertEquals(role, staff.getRole());
        assertEquals(password, staff.getPassword());
    }

    @Test
    public void testStaffDefaultConstructorAndSetters() {
        Staff staff = new Staff(0, null, null, null, null, null); 

        staff.setId(2);
        staff.setName("Rashmi Gunathilaka");
        staff.setEmail("rashmigunathilaka@gmail.com");
        staff.setPhone("0777654321");
        staff.setRole("Waiter");
        staff.setPassword("Rashmi4567");

        assertEquals(2, staff.getId());
        assertEquals("Rashmi Gunathilaka", staff.getName());
        assertEquals("rashmigunathilaka@gmail.com", staff.getEmail());
        assertEquals("0777654321", staff.getPhone());
        assertEquals("Waiter", staff.getRole());
        assertEquals("Rashmi4567", staff.getPassword());
    }

    @Test
    public void testGettersAndSetters() {
        Staff staff = new Staff(0, null, null, null, null, null); 

        staff.setId(3);
        staff.setName("Dasun Pathirana");
        staff.setEmail("dasunpathirana@gmail.com");
        staff.setPhone("0778567890");
        staff.setRole("Chef");
        staff.setPassword("Dasun123");

        assertEquals(3, staff.getId());
        assertEquals("Dasun Pathirana", staff.getName());
        assertEquals("dasunpathirana@gmail.com", staff.getEmail());
        assertEquals("0778567890", staff.getPhone());
        assertEquals("Chef", staff.getRole());
        assertEquals("Dasun123", staff.getPassword());
    }

    @Test
    public void testStaffRoleSetter() {
        Staff staff = new Staff(0, null, null, null, null, null);
        String role = "Supervisor";

        staff.setRole(role);

        assertEquals(role, staff.getRole());
    }

    @Test
    public void testStaffPasswordSetter() {
        Staff staff = new Staff(0, null, null, null, null, null);
        String password = "newPassword456";

        staff.setPassword(password);

        assertEquals(password, staff.getPassword());
    }
}
