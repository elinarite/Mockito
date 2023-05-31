package mockito.task1;

public interface EmailClient {
    boolean sendEmail(String recipient, String message) throws NullPointerException;
}