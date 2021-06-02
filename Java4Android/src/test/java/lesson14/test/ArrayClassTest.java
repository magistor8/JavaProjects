package lesson14.test;

import lesson14.Dz.ArrayClass;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ArrayClassTest {

    @BeforeEach
    void startUp() {
        System.out.println("Начало теста");
    }

    @BeforeAll
    static void init() {
        System.out.println("ГЛАВНЫЙ СТАРТ!");
    }

    @AfterAll
    static void end() {
        System.out.println("ГЛАВНЫЙ КОНЕЦ!");
    }

    @DisplayName("Проверка возврата нового массива значений после последней четверки")
    @ParameterizedTest
    @MethodSource("arrayMagic")
    void paramTest(int[] result, int[] initialArray) {
        Assertions.assertArrayEquals(result, ArrayClass.arrayMagic(initialArray));
    }

    static Stream<Arguments> arrayMagic() {
        return Stream.of(
                Arguments.arguments(new int[]{5, 6}, new int[]{1, 2, 2, 6, 8, 1, 4, 5, 6}),
                Arguments.arguments(new int[]{3, 5, 6}, new int[]{1, 2, 4, 6, 8, 4, 3, 5, 6})
        );
    }

    @DisplayName("Проверка исключения")
    @ParameterizedTest
    @MethodSource("checkException")
    void paramTest(int[] initialArray) {
        Assertions.assertThrows(RuntimeException.class, () -> ArrayClass.check(initialArray));
    }

    static Stream<Arguments> checkException() {
        return Stream.of(
                Arguments.arguments((Object) new int[]{1, 2, 7, 6, 8, 1, 2, 5, 6}),
                Arguments.arguments((Object) new int[]{1, 2, 1, 6, 8, 1, 1, 5, 6})
        );
    }
}
