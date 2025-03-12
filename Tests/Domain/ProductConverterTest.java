package Domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductConverterTest {
    ProductConverter productConverter = new ProductConverter();
    Product p = new Product(1, "HP", "TI", 1200);
    String s = "2,Iphone,TI,1600";

    @Test
    void toStringTest() {
        String s1 = productConverter.toString(p);
        assertEquals(s1, "1,HP,TI,1200");
    }

    @Test
    void fromStringTest() {
        Product p1 = productConverter.fromString(s);
        assertEquals(p1.getID(), 2);
        assertEquals(p1.getName(), "Iphone");
        assertEquals(p1.getCategory(), "TI");
        assertEquals(p1.getPrice(), 1600);
    }
}