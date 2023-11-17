import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

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

    @Mock
    private ToDoList toDoList;

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
        toDoList = mock(ToDoList.class);
        when(toDoList.save()).thenThrow(RuntimeException.class);
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
    void saveTesting() {
        assertThrows(RuntimeException.class, toDoList::save);
    }

    @Test
    void checkEmailSend() throws InstantiationException {
        ToDoList toDoList = new ToDoList(validUser);
        ArrayList<Item> items = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            items.add(new Item("lorem","lorem lorem lorem"));
        }
        toDoList.setItemList(items);
    }
}
