package lesson14.test;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.stream.Stream;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void startUp() {
        System.out.println("Начало теста");
        calculator = new Calculator();
    }

    @AfterEach
    void shutdown() {
        System.out.println("Окончание теста");
    }

    @BeforeAll
    static void init() {
        System.out.println("ГЛАВНЫЙ СТАРТ!");
    }

    @AfterAll
    static void end() {
        System.out.println("ГЛАВНЫЙ КОНЕЦ!");
    }

    @DisplayName("Сложение 1 + 2 = 4")
    @Test
    void testAdd() {
        Assertions.assertEquals(4, calculator.add(1, 2));
    }

    @Test
    void testAdd2() {
        Assertions.assertEquals(4, calculator.add(2, 2));
    }

    @Test
    void testAdd3() {
        Assertions.assertEquals(5, calculator.add(3, 2));
    }

    @DisplayName("Проверка исключения")
    @Test
    void testDiv() {
        Assertions.assertThrows(ArithmeticException.class, () -> {
            calculator.div(8, 0);
        });
    }

    @DisplayName("Проверка таймаута")
    @Test
    void testDivTimeout() {
        Assertions.assertTimeout(Duration.ofSeconds(3), () -> {
//            Thread.sleep(4000);
            calculator.div(8, 2);

        });
    }

    @DisplayName("Параметризированный тест")
    @ParameterizedTest
    @MethodSource("data")
    void paramTest(int expectedSum, int valA, int valB) {
        Assertions.assertEquals(expectedSum, calculator.add(valA, valB));
    }

    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.arguments(3, 1, 2),
                Arguments.arguments(5, 1, 3),
                Arguments.arguments(4, 2, 2),
                Arguments.arguments(0, Integer.MAX_VALUE, Integer.MIN_VALUE),
                Arguments.arguments(Integer.MIN_VALUE, 1, Integer.MAX_VALUE),
                Arguments.arguments(-5, -3, -2)
        );
    }



}