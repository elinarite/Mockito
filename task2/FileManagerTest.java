package mockito.task2;

//Создайте класс FileManager, который зависит от класса FileReader. FileReader содержит метод readFile(String filePath),
// возвращающий содержимое файла. Напишите тест, используя Mockito, чтобы проверить, что метод readFile был вызван
// с правильным путем к файлу и обработан корректно.

import mockito.task1.FileManager;
import mockito.task1.FileReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

class FileManagerTest {

    FileReader fileReader = Mockito.mock(FileReader.class);
    FileManager fileManager = new FileManager(fileReader);

    @Test
    void createText() {
        String filePath = "user/mape/file";
        String message = "message";
        Mockito.when(fileReader.readFile(filePath)).thenReturn(message);
        String testMessage = fileManager.createText(filePath);
        verify(fileReader).readFile(filePath);
        Assertions.assertEquals(message, testMessage);
    }
}