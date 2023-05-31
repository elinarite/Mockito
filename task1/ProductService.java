package mockito.task1;

//Создайте класс ProductService, который зависит от классов ProductRepository и InventoryManager.
// ProductRepository содержит метод getProductById(String productId), возвращающий объект Product по
// идентификатору продукта. InventoryManager содержит метод updateStock(String productId, int quantity),
// обновляющий количество товара на складе. Напишите тест, используя Mockito, чтобы убедиться, что методы
// getProductById и updateStock были вызваны с правильными аргументами.
public class ProductService {
    private ProductRepository productRepository;
    private InventoryManager inventoryManager;

    public ProductService() {
    }

    public ProductService(ProductRepository productRepository, InventoryManager inventoryManager) {
        this.productRepository = productRepository;
        this.inventoryManager = inventoryManager;
    }

    public void processingProductImport(int quantity, String productId){
        Product product = productRepository.getProductById(productId);
        if(product !=null){
            inventoryManager.updateStock(productId, quantity);
        }


    }

}
