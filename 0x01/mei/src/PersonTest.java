import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {
    private Person person;
    @BeforeEach
    public void setup() {
        person = new Person("Paul", "McCartney", new Date(2000), true, true, true);
    }

    @Test
    public void show_full_name() {
        assertEquals("Paul McCartney", person.fullName());
    }

    @Test
    public void test_calculateYearlySalary() {
        person.setSalary(1200);
        assertEquals(14400, person.calculateYearlySalary());
    }

    @Test
    public void person_is_MEI() {
        person.setAnotherCompanyOwner(false);
        person.setPensioner(false);
        person.setPublicServer(false);
        assertTrue(person.isMEI());
    }

    @Test
    public void person_is_not_MEI() {
        assertFalse(person.isMEI());
    }
}
