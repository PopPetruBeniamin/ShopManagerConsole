package Domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IDGeneratorTest {
    @BeforeEach
    public void resetIDs() {
        IDGenerator.productId = 100;
        IDGenerator.orderId = 100;
    }

    @Test public void testGenerateProductID() {
        int id1 = IDGenerator.generatorProductID();
        int id2 = IDGenerator.generatorProductID();
        assertEquals(101, id1, "El primer ID generado debería ser 101");
        assertEquals(102, id2, "El segundo ID generado debería ser 102");
    }
    @Test public void testGenerateOrderID() {
        int id1 = IDGenerator.generatorOrderID();
        int id2 = IDGenerator.generatorOrderID();
        assertEquals(101, id1, "El primer ID generado debería ser 101");
        assertEquals(102, id2, "El segundo ID generado debería ser 102");
    }
}