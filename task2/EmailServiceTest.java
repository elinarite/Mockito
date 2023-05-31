package mockito.task2;

///Создайте класс EmailService, который зависит от класса EmailClient. EmailClient предоставляет метод
// sendEmail(String recipient, String message), отправляющий электронную почту. Напишите тест, используя Mockito,
// чтобы убедиться, что метод sendEmail был вызван с правильными аргументами и обработан корректно.

import mockito.task1.EmailClient;
import mockito.task1.EmailService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

class EmailServiceTest {
    EmailClient emailClient = Mockito.mock(EmailClient.class);
    EmailService emailService = new EmailService(emailClient);

    @BeforeEach
    public void emailClientBehavior() {
        Mockito.when(emailClient.sendEmail(anyString(), anyString())).thenReturn(true);
        Mockito.doThrow(NullPointerException.class).when(emailClient).sendEmail(isNull(), isNull());
        Mockito.doThrow(NullPointerException.class).when(emailClient).sendEmail(isNull(), anyString());
        Mockito.doThrow(NullPointerException.class).when(emailClient).sendEmail(anyString(), isNull());
    }

    @ParameterizedTest
    @CsvSource({"'1', '2'"})
    void sendEmailTrue(String recipient, String message) {
        Assertions.assertTrue(emailService.emailCheck(recipient, message));
    }

    @ParameterizedTest
    @CsvSource({"'1', '2'"})
    void sendEmailFalse(String recipient, String message) {
        Mockito.when(emailClient.sendEmail(anyString(), anyString())).thenReturn(false);
        Assertions.assertFalse(emailService.emailCheck(recipient, message));
    }

    @ParameterizedTest
    @CsvSource({"'1', '2'"})
    void sendEmailArguments(String recipient, String message) {
        emailService.emailCheck(recipient, message);
        verify(emailClient, times(1)).sendEmail(eq(recipient), eq(message));
    }

    @ParameterizedTest
    @CsvSource({"'1', '2'"})
    void sendEmailThrows(String recipient, String message) {
        Assertions.assertThrows(NullPointerException.class, () -> emailClient.sendEmail(null, null));
        Assertions.assertThrows(NullPointerException.class, () -> emailClient.sendEmail(recipient, null));
        Assertions.assertThrows(NullPointerException.class, () -> emailClient.sendEmail(null, message));
    }
}