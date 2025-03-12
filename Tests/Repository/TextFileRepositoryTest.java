package Repository;

import Domain.Product;
import Domain.ProductConverter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;


class TextFileRepositoryTest {

    private final String fileName = "Tests\\Resources\\Data\\TextFiles\\products.txt";
    private TextFileRepository<Product> repository = new TextFileRepository<>(fileName, new ProductConverter());

    @Test
    void testAdd() {
        Product product = new Product(1, "CocaCola", "Food", 2);
        repository.add(product);

        List<Product> products = repository.getAll();
        assertEquals(1, products.size());
        assertEquals(product, products.getFirst());
    }

    @Test
    void testUpdateByID() {
        Product updatedProduct = new Product(2, "CocaCola Light", "Food", 3);
        boolean updated = repository.updateByID(1, updatedProduct);

        assertTrue(updated);
        List<Product> products = repository.getAll();
        assertEquals(1, products.size());
        assertEquals("CocaCola Light", products.getFirst().getName());
    }

    @Test
    void testDeleteByID() {
        repository.deleteByID(1);

        List<Product> products = repository.getAll();
        System.out.println(products.getFirst());
        assertEquals(0, products.size());
    }

    @Test
    void testWriteAndLoadFromFile(){
        Product product1 = new Product(3, "Sprite", "Food", 2);

        repository.add(product1);
        List<Product> products = repository.getAll();
        assertEquals(1, products.size());
        assertEquals(product1.getID(), products.getFirst().getID());
        assertEquals(product1.getName(), products.getFirst().getName());
        assertEquals(product1.getCategory(), products.getFirst().getCategory());
        assertEquals(product1.getPrice(), products.getFirst().getPrice());
        repository.deleteByID(3);

        repository = new TextFileRepository<>("Tests\\Resources\\Data\\TextFiles\\products2.txt", new ProductConverter());

        Product product2 = new Product(1, "Sprite", "Food", 2);
        repository.add(product2);
        products = repository.getAll();

        assertEquals(1, products.size());
        assertEquals(product2.getID(), products.getFirst().getID());
        assertEquals(product2.getName(), products.getFirst().getName());
        assertEquals(product2.getCategory(), products.getFirst().getCategory());
        assertEquals(product2.getPrice(), products.getFirst().getPrice());
        repository.deleteByID(1);
    }
}
