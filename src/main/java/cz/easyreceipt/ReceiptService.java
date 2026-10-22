package cz.easyreceipt;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class ReceiptService {
    public Receipt createReceipt(String receiptNumber, List<Product> products) {
        return new Receipt(receiptNumber, LocalDateTime.now(), products);
    }

    public BigDecimal calculateTotal(List<Product> products) {
        if (products == null || products.isEmpty()) {
            throw new IllegalArgumentException("Seznam produktu nesmi byt prazdny.");
        }
        return products.stream()
                .map(Product::getTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
