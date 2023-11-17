import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ToDoListTest {

    @Mock
    private User user;

    User validUser;
    User invalidUser;
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
        invalidUser = new User(email, firstName, lastName, password, 10);
    }

    @Test
    void createToDoList(){

    }

    @Test
    void createInvalidUserList() {
        assertThrows(InstantiationException.class, () -> new ToDoList(invalidUser));
    }

    @Test
    void saveTesting() throws InstantiationException {
        ToDoList toDoList = new ToDoList(validUser);
        assertThrows(RuntimeException.class, toDoList::save);
    }
}
