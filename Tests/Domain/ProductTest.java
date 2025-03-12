package Domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    Product product = new Product(101, "Mercedes", "Cars", 80000);

    @Test
    void defaultConstructorTest() {
        Product p = new Product();
        assertEquals(p.getID(), -1);
        assertEquals(p.getName(), "");
        assertEquals(p.getCategory(), "");
        assertEquals(p.getPrice(), 0);
    }
    @Test
    void testGetID() {
        assertEquals(product.getID(), 101);
    }

    @Test
    void testGetCategory() {
        assertEquals(product.getCategory(), "Cars");
    }

    @Test
    void testGetPrice() {
        assertEquals(product.getPrice(), 80000);
    }

    @Test
    void testGetName() {
        assertEquals(product.getName(), "Mercedes");
    }

    @Test
    void testSetCategory() {
        assertEquals(product.getCategory(), "Cars");
        product.setCategory("Furniture");
        assertEquals("Furniture", product.getCategory());
    }

    @Test
    void testSetName() {
        assertEquals(product.getName(), "Mercedes");
        product.setName("Sofa");
        assertEquals("Sofa", product.getName());
    }

    @Test
    void testSetPrice() {
        assertEquals(product.getPrice(), 80000);
        product.setPrice(567);
        assertEquals(product.getPrice(), 567);
    }

    @Test
    void set() {
        Product newProduct = new Product(102, "Audi", "Cars", 90000);
        product.updateFrom(newProduct);
        assertEquals(product.getID(), 101);
        assertEquals(product.getName(), "Audi");
        assertEquals(product.getCategory(), "Cars");
        assertEquals(product.getPrice(), 90000);
    }

    @Test
    void testToString() {
        assertEquals(product.toString(), "Product,101,Mercedes,Cars,80000");
    }

}