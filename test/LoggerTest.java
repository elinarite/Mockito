package mockito.test;
//Создайте класс Logger, который содержит метод log(String message),
// записывающий сообщение в журнал. Напишите тест, используя Mockito,
// чтобы убедиться, что метод log был вызван хотя бы один раз.

import mockito.task1.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class LoggerTest {
    Logger newLog = Mockito.mock(Logger.class);
    List<String> stringList = new ArrayList<>();

    @Test
    void log() {
        String message = "ok";
        Mockito.doAnswer(invocation -> {
            String argument = invocation.getArgument(0);
            return stringList.add(argument);
        }).when(newLog).log(Mockito.anyString());

        newLog.log(message);
        Assertions.assertEquals(1, stringList.size());
        Assertions.assertEquals(message, stringList.get(0));
    }

    @Test
    void logSelf() {
        String message = "ok";
        Mockito.doNothing().when(newLog).log(Mockito.anyString());
        newLog.log(message);
        verify(newLog, times(1)).log(message);
    }
}