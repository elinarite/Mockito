package mockito.task2;
////уровень сложности: Уровень сложности 1 из 10:
////Создайте класс Calculator, который содержит метод add(int a, int b) для сложения
////двух чисел. Напишите тест, используя Mockito, чтобы убедиться, что метод add был
//// вызван правильно.

import mockito.task1.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class CalculatorTest {
    Calculator newCalc = Mockito.mock(Calculator.class);

    @ParameterizedTest
    @CsvSource({"6,6"})
    void add(int a, int b) {
        Mockito.when(newCalc.add(a, b)).thenReturn(12);
        int result = newCalc.add(6, 6);
        Assertions.assertEquals(12, result);
    }

    @Test
    void add() {
        Mockito.when(newCalc.add(anyInt(), anyInt())).thenReturn(12);
        int result = newCalc.add(6, 6);
        Assertions.assertEquals(12, result);
    }

    @Test
    void verifyAdd() {
        newCalc.add(6, 6);
        verify(newCalc).add(6, 6);
    }

    @Test
    void verifyAdd2() {
        newCalc.add(6, 6);
        verify(newCalc, times(1)).add(6, 6);
    }
}