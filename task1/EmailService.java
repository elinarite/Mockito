package mockito.task1;

//Создайте класс EmailService, который зависит от класса EmailClient. EmailClient предоставляет метод
// sendEmail(String recipient, String message), отправляющий электронную почту. Напишите тест, используя Mockito,
// чтобы убедиться, что метод sendEmail был вызван с правильными аргументами и обработан корректно.
public class EmailService {
    private EmailClient emailClient;

    public EmailService(EmailClient emailClient) {
        this.emailClient = emailClient;
    }

    public EmailService() {
    }

    public boolean emailCheck(String recipient, String message) {
        if (emailClient.sendEmail(recipient, message)) {
            return true;
        }
        return false;
    }
}