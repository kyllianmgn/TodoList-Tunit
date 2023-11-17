import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    User user;
    String email = "username@mail.com";
    String firstName = "John";
    String lastName = "Smith";
    String password = "AzErTy1234";
    int age = 20;

    @BeforeEach
    void setUp() {
        user = new User(email, firstName, lastName, password, age);
    }

    @Test
    void gettersNominal() {
        assertEquals(email, user.getEmail());
        assertEquals(firstName, user.getFirstName());
        assertEquals(lastName, user.getLastName());
        assertEquals(password, user.getPassword());
        assertEquals(age, user.getAge());
    }
}
