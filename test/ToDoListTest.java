import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.stubbing.OngoingStubbing;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ToDoListTest {

    @Mock
    private User user;

    User validUser;
    User nonValidUser;
    String email = "username@mail.com";
    String firstName = "John";
    String lastName = "Smith";
    String password = "AzErTy1234";
    int age = 20;

    @BeforeEach
    void setUp() {
        EmailSenderService emailSenderService = mock(EmailSenderService.class);
        when(emailSenderService.sendEmail(anyString())).thenReturn(true);
        user = mock(User.class);
        when(user.isValid()).thenReturn(false);
        validUser = new User(email, firstName, lastName, password, age);
        nonValidUser = new User(email, firstName, lastName, password, 10);
    }

    @Test
    void createList() {

    }
}
