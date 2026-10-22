package cz.easyreceipt;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    @Test
    void calculatesProductTotal() {
        Product product = new Product("Mleko", new BigDecimal("25.90"), 2);
        assertEquals(new BigDecimal("51.80"), product.getTotal());
    }

    @Test
    void rejectsZeroQuantity() {
        assertThrows(IllegalArgumentException.class,
                () -> new Product("Chleba", new BigDecimal("34.90"), 0));
    }

    @Test
    void rejectsNegativePrice() {
        assertThrows(IllegalArgumentException.class,
                () -> new Product("Chleba", new BigDecimal("-1.00"), 1));
    }
}
