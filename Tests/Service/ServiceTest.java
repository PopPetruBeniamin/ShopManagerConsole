package Service;

import Domain.Order;
import Domain.Product;
import Repository.InMemoryRepository;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ServiceTest {
    InMemoryRepository<Product> products = new InMemoryRepository<>();
    InMemoryRepository<Order> orders = new InMemoryRepository<>();
    Service service = new Service(orders, products);

    Product givenProduct1 = new Product(1, "CocaCola", "Food", 2);
    Product givenProduct2 = new Product(2, "Iphone16", "Technology", 3);
    Product givenProduct3 = new Product(3, "Sofa", "Furniture", 10);
    Product givenProduct4 = new Product(4, "Batman", "Entertainment", 10);

    List<Integer> products1 = List.of(givenProduct1.getID(), givenProduct1.getID(), givenProduct2.getID(), givenProduct2.getID(), givenProduct3.getID());
    List<Integer> products2 = List.of(givenProduct3.getID(), givenProduct4.getID());

    Order order1 = new Order(1, LocalDate.of(2024, 12, 12), products1);
    Order order2 = new Order(LocalDate.of(2024, 12, 11), products2);

    @Test
    void addProduct() {
        service.addProduct(givenProduct1);
        service.addProduct(givenProduct2);

        assertEquals(service.getAllProducts().size(), 2);
        assertEquals(service.getAllProducts().getFirst().getID(), givenProduct1.getID());
        assertEquals(service.getAllProducts().getFirst().getName(), givenProduct1.getName());
        assertEquals(service.getAllProducts().getFirst().getCategory(), givenProduct1.getCategory());
        assertEquals(service.getAllProducts().getFirst().getPrice(), givenProduct1.getPrice());
        assertEquals(service.getAllProducts().get(1).getID(), givenProduct2.getID());
        assertEquals(service.getAllProducts().get(1).getName(), givenProduct2.getName());
        assertEquals(service.getAllProducts().get(1).getCategory(), givenProduct2.getCategory());
        assertEquals(service.getAllProducts().get(1).getPrice(), givenProduct2.getPrice());
    }

    @Test
    void updateProduct() {
        service.addProduct(givenProduct1);

        service.updateProduct(1, givenProduct2);
        assertEquals(service.getAllProducts().getFirst().getID(), 1);
        assertEquals(service.getAllProducts().getFirst().getName(), givenProduct2.getName());
        assertEquals(service.getAllProducts().getFirst().getCategory(), givenProduct2.getCategory());
        assertEquals(service.getAllProducts().getFirst().getPrice(), givenProduct2.getPrice());
    }

    @Test
    void deleteProductByID() {
        service.addProduct(givenProduct1);
        service.addProduct(givenProduct2);

        service.deleteProductByID(1);
        assertEquals(service.getAllProducts().size(), 1);
        assertEquals(service.getAllProducts().getFirst().getID(), givenProduct2.getID());
        assertEquals(service.getAllProducts().getFirst().getName(), givenProduct2.getName());
        assertEquals(service.getAllProducts().getFirst().getCategory(), givenProduct2.getCategory());
        assertEquals(service.getAllProducts().getFirst().getPrice(), givenProduct2.getPrice());
    }

    @Test
    void getProductByID() {
        service.addProduct(givenProduct1);
        Product p = service.getProductByID(1);
        assertEquals(p.getID(), 1);
        assertEquals(p.getName(), "CocaCola");
        assertEquals(p.getCategory(), "Food");
        assertEquals(p.getPrice(), 2);
    }

    @Test
    void getAllProducts() {
        service.addProduct(givenProduct1);
        List<Product> l = service.getAllProducts();
        assertEquals(l.size(), 1);
        assertEquals(l.getFirst().getID(), 1);
        assertEquals(l.getFirst().getName(), "CocaCola");
        assertEquals(l.getFirst().getCategory(), "Food");
        assertEquals(l.getFirst().getPrice(), 2);
    }

    @Test
    void addOrder() {
        service.addOrder(order1);

        assertEquals(service.getAllOrders().size(), 1);
        assertEquals(service.getAllOrders().getFirst().getID(), order1.getID());
        assertEquals(service.getAllOrders().getFirst().getDate(), order1.getDate());
        assertEquals(service.getAllOrders().getFirst().getIDProducts(), order1.getIDProducts());
    }

    @Test
    void deleteOrderByID() {
        service.addOrder(order1);
        service.deleteOrderByID(1);
        assertEquals(service.getAllProducts().size(), 0);
    }

    @Test
    void updateOrderByID(){
        service.addOrder(order1);
        service.updateOrder(1, order2);
        assertEquals(service.getAllOrders().size(), 1);
        assertEquals(service.getAllOrders().getFirst().getID(), order1.getID());
        assertEquals(service.getAllOrders().getFirst().getDate(), order2.getDate());
        assertEquals(service.getAllOrders().getFirst().getIDProducts(), order2.getIDProducts());
    }

    @Test
    void getAllOrders() {
        service.addOrder(order1);

        List<Order> l = service.getAllOrders();
        assertEquals(l.size(), 1);
        assertEquals(l.getFirst().getID(), order1.getID());
        assertEquals(l.getFirst().getDate(), order1.getDate());
        assertEquals(l.getFirst().getIDProducts(), order1.getIDProducts());
    }
}