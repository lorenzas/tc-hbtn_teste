import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PersonTest {
    private Person person;
    @BeforeAll
    public void setup() {
        person = new Person();
    }

    @ParameterizedTest(name = "Is the user {0} valid?")
    @ValueSource(strings = {"PaulMcCartney2", "NeilArms2"})
    public void check_user_valid(String user) {
        person.setUser(user);
        assertTrue(person.checkUser());
    }

    @ParameterizedTest(name = "Is the user {0} not valid?")
    @ValueSource(strings = {"Paul#McCartney", "Neil@Arms"})
    public void check_user_not_valid(String user) {
        person.setUser(user);
        assertFalse(person.checkUser());
    }

    @ParameterizedTest(name = "Doesn't the password '{0}' have letters?")
    @ValueSource(strings = {"123456789", "#$%1234"})
    public void does_not_have_letters(String password) {
        person.setPassword(password);
        assertFalse(person.checkPassword());
    }

    @ParameterizedTest(name = "Doesn't the password '{0}' have numbers?")
    @ValueSource(strings = {"Abcabcdefgh@", "#hbtn@%tc"})
    public void does_not_have_numbers(String password) {
        person.setPassword(password);
        assertFalse(person.checkPassword());
    }

    @ParameterizedTest(name = "Doesn't the password '{0}' have eight chars?")
    @ValueSource(strings = {"Abc@123", "12$@hbt"})
    public void does_not_have_eight_chars(String password) {
        person.setPassword(password);
        assertFalse(person.checkPassword());
    }

    @ParameterizedTest(name = "Is the password {0} valid?")
    @ValueSource(strings = {"abC123456$", "Hbtn@1234", "Betty@1#2", "Hbtn@123"})
    public void check_password_valid(String password) {
        person.setPassword(password);
        assertTrue(person.checkPassword());
    }
}
