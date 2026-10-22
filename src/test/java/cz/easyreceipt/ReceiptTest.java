package cz.easyreceipt;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ReceiptTest {
    @Test
    void sumsAllProducts() {
        Receipt receipt = new Receipt("0001", LocalDateTime.now(), List.of(
                new Product("Mleko", new BigDecimal("25.90"), 2),
                new Product("Chleba", new BigDecimal("34.90"), 1)));
        assertEquals(new BigDecimal("86.70"), receipt.getTotal());
    }

    @Test
    void rejectsEmptyReceipt() {
        assertThrows(IllegalArgumentException.class,
                () -> new Receipt("0001", LocalDateTime.now(), List.of()));
    }
}
