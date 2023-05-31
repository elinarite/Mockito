package mockito.task2;

import mockito.task1.PaymentGateway;
import mockito.task1.PaymentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.AdditionalMatchers.gt;
import static org.mockito.AdditionalMatchers.lt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

//Создайте класс PaymentService, который зависит от класса PaymentGateway. PaymentGateway
// содержит метод processPayment(double amount), который возвращает true, если платеж успешно
// обработан, и false в противном случае. Напишите тест, используя Mockito, чтобы проверить,
// что метод processPayment был вызван и вернул ожидаемый результат.
class PaymentServiceTest {

    PaymentGateway newGet = Mockito.mock(PaymentGateway.class);
    PaymentService paymentService = new PaymentService(newGet);

    @BeforeEach
    void processPayment() {
        Mockito.when(newGet.processPayment1(gt(0.0))).thenReturn(true);
        Mockito.when(newGet.processPayment1(lt(0.0))).thenReturn(false);
        double positive = 100;
        double negative = -100;
        boolean trueResult = newGet.processPayment1(positive);
        boolean falseResult = newGet.processPayment1(negative);
        Assertions.assertTrue(trueResult);
        Assertions.assertFalse(falseResult);
        verify(newGet, times(1)).processPayment1(positive);
    }

    @Test
    void makePaymentTrue() {
        double positive = 100;
        boolean result = paymentService.makePayment(positive);
        verify(newGet, times(2)).processPayment1(positive);
        //times 2, because in method processPayment() is first time
        assertTrue(result);
    }

    @Test
    void makePaymentFalse() {
        double negative = -100;
        boolean result = paymentService.makePayment(negative);
        verify(newGet, times(2)).processPayment1(negative);
        //times 2, because in method processPayment() is first time
        assertFalse(result);
    }
}