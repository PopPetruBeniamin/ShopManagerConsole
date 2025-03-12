package Domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderConverterTest {

    OrderConverter orderConverter = new OrderConverter();
    Product givenProduct1 = new Product(1, "CocaCola", "Food", 2);
    Product givenProduct2 = new Product(2, "Iphone16", "Technology", 3);
    Product givenProduct3 = new Product(3, "Sofa", "Furniture", 10);

    List<Integer> products1 = List.of(givenProduct1.getID(), givenProduct1.getID(), givenProduct2.getID(), givenProduct2.getID(), givenProduct3.getID());

    Order order = new Order(1, LocalDate.of(2024, 12, 12), products1);
    String string = "2,2023-12-12,1|1|2|2|3";

    @Test
    void toStringTest() {
        String s1 = orderConverter.toString(order);
        assertEquals(s1, "1,2024-12-12,1|1|2|2|3");
    }

    @Test
    void fromStringTest() {
        Order o1 = orderConverter.fromString(string);
        assertEquals(o1.getID(), 2);
        assertEquals(o1.getDate(), LocalDate.of(2023, 12, 12));
        assertEquals(o1.getIDProducts(), products1);
    }
}