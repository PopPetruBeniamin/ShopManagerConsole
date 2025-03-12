package Domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    Product givenProduct1 = new Product(1, "CocaCola", "Food", 2);
    Product givenProduct2 = new Product(2, "Iphone16", "Technology", 3);
    Product givenProduct3 = new Product(3, "Sofa", "Furniture", 10);
    Product givenProduct4 = new Product(4, "Batman", "Entertainment", 10);

    List<Integer> products1 = List.of(givenProduct1.getID(), givenProduct1.getID(), givenProduct2.getID(), givenProduct2.getID(), givenProduct3.getID());
    List<Integer> products2 = List.of(givenProduct3.getID(), givenProduct4.getID());

    Order order1 = new Order(1, LocalDate.of(2024, 12, 12), products1);
    Order order2 = new Order(LocalDate.of(2024, 12, 11), products2);

    @Test
    void defaultConstructorTest() {
        Order o = new Order();
        assertEquals(o.getID(), -1);
        assertEquals(o.getDate(), null);
        assertEquals(o.getIDProducts(), null);
    }

    @Test
    void getID() {
        assertEquals(order1.getID(), 1);
    }

    @Test
    void getIDProducts() {
        assertEquals(order1.getIDProducts(), products1);
    }

    @Test
    void getDate() {
        assertEquals(order1.getDate(), LocalDate.of(2024, 12, 12));
    }

    @Test
    void setIDProducts() {
        order1.setIDProducts(products2);
        assertEquals(order1.getIDProducts(), products2);
    }

    @Test
    void setDate() {
        order1.setDate(LocalDate.of(2024, 11, 12));
        assertEquals(order1.getDate(), LocalDate.of(2024, 11, 12));
    }

    @Test
    void updateFrom() {
        order1.updateFrom(order2);
        assertEquals(order1.getID(), 1);
        assertEquals(order1.getDate(), LocalDate.of(2024, 12, 11));
        assertEquals(order1.getIDProducts(), products2);
    }

    @Test
    void testToString() {
        assertEquals(order1.toString(), "Order,1,2024-12-12,1|1|2|2|3");
    }
}