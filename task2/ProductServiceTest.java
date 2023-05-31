package mockito.task2;

import mockito.task1.InventoryManager;
import mockito.task1.Product;
import mockito.task1.ProductRepository;
import mockito.task1.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

//Создайте класс ProductService, который зависит от классов ProductRepository и InventoryManager.
// ProductRepository содержит метод getProductById(String productId), возвращающий объект Product по
// идентификатору продукта. InventoryManager содержит метод updateStock(String productId, int quantity),
// обновляющий количество товара на складе. Напишите тест, используя Mockito, чтобы убедиться, что методы
// getProductById и updateStock были вызваны с правильными аргументами.
class ProductServiceTest {

    ProductRepository productRepository = Mockito.mock(ProductRepository.class);
    InventoryManager inventoryManager = Mockito.mock(InventoryManager.class);
    ProductService productService = new ProductService(productRepository, inventoryManager);
    Product product = Mockito.mock(Product.class);


    @Test
    void getProductById() {
        String productId = "123";
        Mockito.when(productRepository.getProductById(productId)).thenReturn(product);
        Product product1 = productRepository.getProductById(productId);
        Assertions.assertEquals(product1, productRepository.getProductById(productId));
    }

    @Test
    void updateStock() {

        int quantity = 10;
        String productId = "123";
        Mockito.doNothing().when(inventoryManager).updateStock(anyString(), anyInt());
        inventoryManager.updateStock(productId, quantity);
        verify(inventoryManager).updateStock(productId, quantity);
    }
}