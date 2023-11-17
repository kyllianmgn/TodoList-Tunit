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

    @Test
    void validUser() {
        assertTrue(user.isValid());
    }

    @Test
    void invalidAgeUser() {
        user.setAge(10);
        assertFalse(user.isValid());
    }

    @Test
    void invalidLastNameUser() {
        user.setLastName("");
        assertFalse(user.isValid());
    }

    @Test
    void invalidFirstNameUser() {
        user.setFirstName("");
        assertFalse(user.isValid());
    }

    @Test
    void invalidMailUser() {
        user.setEmail("wrongemailnuhuh");
        assertFalse(user.isValid());
    }

    @Test
    void invalidNoUpperPassword() {
        user.setPassword("jesuisunmdp55");
        assertFalse(user.isValid());
    }

    @Test
    void invalidNoLowerPassword() {
        user.setPassword("JECRIE972");
        assertFalse(user.isValid());
    }

    @Test
    void invalidNoDigitPassword() {
        user.setPassword("pasDEchiffreICI");
        assertFalse(user.isValid());
    }

    @Test
    void invalidShortPassword() {
        user.setPassword("ToUP3t1");
        assertFalse(user.isValid());
    }

    @Test
    void invalidLongPassword() {
        user.setPassword("L0n6L0n6L0n6L0n6L0n6L0n6L0n6L0n6L0n6L0n6L0n6L0n6L0n6L0n6L0n6L0n6L0n6L0n6L0n6L0n6L0n6L0n6L0n6L0n6L0n6");
        assertFalse(user.isValid());
    }
}
