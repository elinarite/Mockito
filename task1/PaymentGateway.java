package mockito.task1;

public interface PaymentGateway {

    boolean processPayment1(double value);

    boolean processPayment(double amount) throws PaymentFailedException;

}