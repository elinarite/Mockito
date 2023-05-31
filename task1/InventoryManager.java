package mockito.task1;

public interface InventoryManager {
    boolean checkStock (String item, int quantity);

    void updateStock(String productId, int quantity);
}
