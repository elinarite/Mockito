package mockito.task1;
//Создайте класс Logger, который содержит метод log(String message),
// записывающий сообщение в журнал. Напишите тест, используя Mockito,
// чтобы убедиться, что метод log был вызван хотя бы один раз.


import java.util.List;

public class Logger {
    private List<String> stringList;

    public Logger(List<String> stringList) {
        this.stringList = stringList;
    }

    public void log(String message) {
        stringList.add(message);
    }

}