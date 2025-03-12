package Repository;

import Domain.Product;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryRepositoryTest {
    InMemoryRepository<Product> repo = new InMemoryRepository<>();
    Product givenProduct1 = new Product(1, "CocaCola", "Food", 2);
    Product givenProduct2 = new Product(2, "Iphone16", "Technology", 3);
    Product givenProduct3 = new Product(3, "Sofa", "Furniture", 10);

    @Test
    void add() {
        repo.add(givenProduct1);
        repo.add(givenProduct2);
        repo.add(givenProduct3);

        assertEquals(repo.getAll().size(), 3);
        assertEquals(repo.getAll().get(0), givenProduct1);
        assertEquals(repo.getAll().get(1), givenProduct2);
        assertEquals(repo.getAll().get(2), givenProduct3);
    }

    @Test
    void deleteByID() {
        repo.add(givenProduct1);
        repo.add(givenProduct2);
        repo.add(givenProduct3);

        repo.deleteByID(2);
        assertEquals(repo.getAll().size(), 2);
        assertEquals(repo.getAll().get(0), givenProduct1);
        assertEquals(repo.getAll().get(1), givenProduct3);
    }

    @Test
    void updateByID() {
        repo.add(givenProduct1);
        repo.add(givenProduct2);

        repo.updateByID(1, givenProduct3);
        assertEquals(repo.getAll().size(), 2);
        assertEquals(repo.getAll().getFirst().getID(), 1);
        assertEquals(repo.getAll().getFirst().getName(), givenProduct3.getName());
        assertEquals(repo.getAll().getFirst().getCategory(), givenProduct3.getCategory());
        assertEquals(repo.getAll().getFirst().getPrice(), givenProduct3.getPrice());
    }

    @Test
    void getByID() {
        repo.add(givenProduct1);

        Product p = repo.getByID(1);
        assertEquals(repo.getAll().size(), 1);
        assertEquals(repo.getAll().getFirst().getID(), 1);
        assertEquals(repo.getAll().getFirst().getName(), p.getName());
        assertEquals(repo.getAll().getFirst().getCategory(), p.getCategory());
        assertEquals(repo.getAll().getFirst().getPrice(), p.getPrice());
    }

    @Test
    void getAll() {
        repo.add(givenProduct1);
        repo.add(givenProduct2);

        List<Product> l = repo.getAll();
        assertEquals(repo.getAll().size(), 2);
        assertEquals(l.get(0), repo.getAll().get(0));
        assertEquals(l.get(1), repo.getAll().get(1));

    }
}