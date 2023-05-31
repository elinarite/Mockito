package mockito.test;

import mockito.task1.EmailSender;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;
////Создайте класс EmailSender, который содержит метод sendEmail(String recipient, String message),
//// отправляющий электронную почту получателю с заданным сообщением. Напишите тест, используя Mockito,
//// чтобы убедиться, что метод sendEmail был вызван с правильными аргументами.

class EmailSenderTest {
    EmailSender newEmail = Mockito.mock(EmailSender.class);

    @ParameterizedTest
    @CsvSource({"'a', 'b'"})
    void calledCorrectArguments(String a, String b) {
        String text = "message sent";
        Mockito.when(newEmail.sendEmail(anyString(), anyString())).thenReturn(text);

        newEmail.sendEmail(a, b);
        verify(newEmail, times(1)).sendEmail(eq(a), eq(b));
    }
}