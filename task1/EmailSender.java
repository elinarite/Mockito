package mockito.task1;

//Создайте класс EmailSender, который содержит метод sendEmail(String recipient, String message),
// отправляющий электронную почту получателю с заданным сообщением. Напишите тест, используя Mockito,
// чтобы убедиться, что метод sendEmail был вызван с правильными аргументами.

public class EmailSender {
    private String recipient;
    private String message;

    public EmailSender() {
    }

    public EmailSender(String recipient, String message) {
        this.recipient = recipient;
        this.message = message;
    }

    public String sendEmail(String recipient, String message) {
        if (recipient == null || message == null) {
            return "message failed to sent";
        }
        return "message sent";
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}