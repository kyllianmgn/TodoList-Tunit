import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.mockito.Mock;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ToDoListTest {

    static class UserArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
            return Stream.of(
                    Arguments.of(new User("ipsum.primis@yahoo.couk", "ipsum", "ipsum", "ipsumipsumipsum", 20)),
                    Arguments.of(new User("at.sem@google.edu", "at", "at", "atatat", 20)),
                    Arguments.of(new User("bibendum@aol.couk", "bibendum", "bibendum", "bibendumbibendumbibendum", 20)),
                    Arguments.of(new User("tristique.pharetra.quisque@yahoo.com", "tristique", "tristique", "tristiquetristiquetristique", 20)),
                    Arguments.of(new User("sit.amet@hotmail.net", "sit", "sit", "sitsitsit", 20))
            );
        }
    }

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
    void createToDoList() {

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
