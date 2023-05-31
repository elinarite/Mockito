package mockito.task2;

import mockito.task1.InventoryManager;
import mockito.task1.OrderService;
import mockito.task1.PaymentFailedException;
import mockito.task1.PaymentGateway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

////Task1   Создайте класс OrderService, который зависит от классов PaymentGateway и
//// InventoryManager. PaymentGateway содержит метод processPayment(double amount),
//// а InventoryManager содержит метод checkStock(String item, int quantity),
//// возвращающий true, если товар есть в наличии в нужном количестве, и false в
//// противном случае. Напишите тест, используя Mockito, чтобы проверить, что методы
//// processPayment и checkStock были вызваны с правильными аргументами.

//Task2 Создайте класс OrderService, который зависит от класса PaymentGateway. PaymentGateway содержит метод processPayment(double amount),
// который может выбросить исключение PaymentFailedException, если платеж не удался. Напишите тест, используя Mockito, чтобы проверить,
// что при выбрасывании исключения PaymentFailedException в нужных случаях, метод processPayment был обработан правильно.
class OrderServiceTest {

    InventoryManager inventoryManager = Mockito.mock(InventoryManager.class);
    mockito.task1.PaymentGateway PaymentGateway = Mockito.mock(PaymentGateway.class);
    OrderService orderService = new OrderService(inventoryManager, PaymentGateway);

    @ParameterizedTest
    @CsvSource({"'a', 2"})
    void checkStock(String item, int quantity) {
        Mockito.when(inventoryManager.checkStock(anyString(), anyInt())).thenReturn(true);
        inventoryManager.checkStock(item, quantity);
        verify(inventoryManager, times(1)).checkStock(eq(item), eq(quantity));
    }

    @Test
    void checkStockTest() {
        Mockito.when(inventoryManager.checkStock(anyString(), anyInt())).thenReturn(true);
        inventoryManager.checkStock("item", 5);
        verify(inventoryManager, times(1)).checkStock("item", 5);
        Assertions.assertTrue(inventoryManager.checkStock("item", 5));
    }

    @Test
    void processPayment() throws PaymentFailedException {
        Mockito.when(PaymentGateway.processPayment(anyDouble())).thenReturn(true);
        PaymentGateway.processPayment(2.5);
        verify(PaymentGateway).processPayment(2.5);
        Assertions.assertTrue(PaymentGateway.processPayment(2.5));
    }

    @Test
    void placeOrderWithPositiveStock() {
        String item = "item";
        int quantity = 20;
        double amount = 10;
        Mockito.when(inventoryManager.checkStock(anyString(), anyInt())).thenReturn(true);
        Mockito.doAnswer((Answer<Boolean>) invocation -> {
            if (amount > 0) {
                return true;
            } else {
                return false;
            }
        }).when(inventoryManager).checkStock(anyString(), anyInt());
        Assertions.assertTrue(orderService.placeOrder(item, quantity, amount));
    }

    @Test
    void testPlaceOrder5() throws PaymentFailedException {
        double amount = -10;
        String item = "item";
        int quantity = 20;

        Mockito.when(inventoryManager.checkStock(anyString(), anyInt())).thenReturn(true);
        Mockito.doAnswer(invocation -> {
            double argAmount = invocation.getArgument(0);
            if (argAmount < 0) {
                throw new PaymentFailedException();
            }
            return null;
        }).when(PaymentGateway).processPayment(anyDouble());

        Assertions.assertThrows(RuntimeException.class, () -> {
            orderService.placeOrder(item, quantity, amount);
        });
    }
}