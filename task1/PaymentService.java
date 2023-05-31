package mockito.task1;
//Создайте класс PaymentService, который зависит от класса PaymentGateway.
// PaymentGateway содержит метод processPayment(double amount), который возвращает true,
// если платеж успешно обработан, и false в противном случае. Напишите тест, используя Mockito,
// чтобы проверить, что метод processPayment был вызван и вернул ожидаемый результат.

public class PaymentService {
    private PaymentGateway paymentGateway;

    public PaymentService(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public boolean makePayment(double value) {
        return paymentGateway.processPayment1(value);
    }
}