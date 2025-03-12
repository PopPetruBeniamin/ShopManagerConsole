package Repository;

import Domain.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;


class BinaryFileRepositoryTest {

    private BinaryFileRepository<Product> repository;
    private final String fileName = "Tests\\Resources\\Data\\BinFiles\\products.bin";

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
        Product updatedProduct = new Product("CocaCola Light", "Food", 3);
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
        assertTrue(products.isEmpty());
    }

    @Test
    void testWriteAndLoadFromFile() {
        Product product = new Product("CocaCola", "Food", 2);
        repository.add(product);

        // Simula la carga desde archivo
        repository = new BinaryFileRepository<>(fileName);
        List<Product> products = repository.getAll();
        assertEquals(1, products.size());
        assertEquals(product.getID(), products.get(0).getID());
        assertEquals(product.getName(), products.get(0).getName());
        assertEquals(product.getCategory(), products.get(0).getCategory());
        assertEquals(product.getPrice(), products.get(0).getPrice());
    }
}
