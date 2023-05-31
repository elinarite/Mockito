package mockito.task1;
//Создайте класс OrderService, который зависит от классов PaymentGateway и
// InventoryManager. PaymentGateway содержит метод processPayment(double amount),
// а InventoryManager содержит метод checkStock(String item, int quantity),
// возвращающий true, если товар есть в наличии в нужном количестве, и false в
// противном случае. Напишите тест, используя Mockito, чтобы проверить, что методы
// processPayment и checkStock были вызваны с правильными аргументами.


public class OrderService {
    private InventoryManager inventoryManager;
    private PaymentGateway PaymentGateway;

    public OrderService() {
    }

    public OrderService(InventoryManager inventoryManager, PaymentGateway PaymentGateway) {
        this.inventoryManager = inventoryManager;
        this.PaymentGateway = PaymentGateway;
    }

    public boolean placeOrder(String item, int quantity, double amount) {
        if (inventoryManager.checkStock(item, quantity)) {
            try {
                if (PaymentGateway.processPayment(amount)) ;
            } catch (PaymentFailedException e) {
                throw new RuntimeException();
            }
            return true;

        }
        return false;
    }
}