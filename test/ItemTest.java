import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    static class ItemArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
            return Stream.of(
                    Arguments.of(new Item("Faire les courses", "Acheter des trucs à manger.")),
                    Arguments.of(new Item("dqsdqsdqs", "1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111"))
            );
        }
    }

    static class WrongItemArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
            return Stream.of(
                    Arguments.of(new Item("Faire les courses", "Acheter des trucs à manger.Acheter des trucs à manger.Acheter des trucs à manger.Acheter des trucs à manger.Acheter des trucs à manger.Acheter des trucs à manger.Acheter des trucs à manger.Acheter des trucs à manger.Acheter des trucs à manger.Acheter des trucs à manger.Acheter des trucs à manger.Acheter des trucs à manger.Acheter des trucs à manger.Acheter des trucs à manger.Acheter des trucs à manger.Acheter des trucs à manger.Acheter des trucs à manger.Acheter des trucs à manger.Acheter des trucs à manger.Acheter des trucs à manger.Acheter des trucs à manger.Acheter des trucs à manger.Acheter des trucs à manger.Acheter des trucs à manger.Acheter des trucs à manger.Acheter des trucs à manger.Acheter des trucs à manger.Acheter des trucs à manger.Acheter des trucs à manger.Acheter des trucs à manger.Acheter des trucs à manger.Acheter des trucs à manger.Acheter des trucs à manger.Acheter des trucs à manger.Acheter des trucs à manger.Acheter des trucs à manger.Acheter des trucs à manger.Acheter des trucs à manger.Acheter des trucs à manger.")),
                    Arguments.of(new Item("dqsdqsdqs", "111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111"))
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(ItemArgumentsProvider.class)
    void checkContentNominal(Item item) {
        assertTrue(item.checkContent());
    }

    @ParameterizedTest
    @ArgumentsSource(WrongItemArgumentsProvider.class)
    void checkContentOver1000(Item item) {
        assertThrows(IllegalArgumentException.class, item::checkContent);
    }
}
