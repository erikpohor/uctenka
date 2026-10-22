package cz.easyreceipt;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Product {
    private final String name;
    private final BigDecimal unitPrice;
    private final int quantity;

    public Product(String name, BigDecimal unitPrice, int quantity) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Nazev produktu nesmi byt prazdny.");
        }
        Objects.requireNonNull(unitPrice, "Cena nesmi byt null.");
        if (unitPrice.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Cena nesmi byt zaporna.");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Mnozstvi musi byt vetsi nez nula.");
        }
        this.name = name.trim();
        this.unitPrice = unitPrice.setScale(2, RoundingMode.HALF_UP);
        this.quantity = quantity;
    }

    public String getName() { return name; }
    public BigDecimal getUnitPrice() { return unitPrice; }
    public int getQuantity() { return quantity; }

    public BigDecimal getTotal() {
        return unitPrice.multiply(BigDecimal.valueOf(quantity)).setScale(2, RoundingMode.HALF_UP);
    }
}
