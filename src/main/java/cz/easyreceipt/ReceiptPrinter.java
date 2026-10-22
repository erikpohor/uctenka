package cz.easyreceipt;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ReceiptPrinter {
    private static final int WIDTH = 42;
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

    public String print(Receipt receipt, StoreConfig store) {
        StringBuilder out = new StringBuilder();
        line(out, "=");
        centered(out, store.getName().toUpperCase(Locale.ROOT));
        centered(out, store.getAddress());
        centered(out, "ICO: " + store.getIco());
        line(out, "=");
        out.append(String.format("Uctenka: %s%n", receipt.getReceiptNumber()));
        out.append(String.format("Datum:   %s%n", receipt.getDateTime().format(DATE_FORMAT)));
        line(out, "-");
        out.append(String.format("%-16s %4s %8s %10s%n", "Polozka", "Ks", "Cena", "Celkem"));
        line(out, "-");
        for (Product product : receipt.getProducts()) {
            String name = product.getName();
            if (name.length() > 16) name = name.substring(0, 13) + "...";
            out.append(String.format(Locale.ROOT, "%-16s %4d %8s %10s%n",
                    name, product.getQuantity(), money(product.getUnitPrice()),
                    money(product.getTotal())));
        }
        line(out, "-");
        out.append(String.format("%-29s %12s%n", "CELKEM:", money(receipt.getTotal())));
        line(out, "=");
        centered(out, "Dekujeme za vas nakup!");
        line(out, "=");
        return out.toString();
    }

    private String money(BigDecimal amount) {
        return String.format(Locale.ROOT, "%.2f", amount);
    }

    private void line(StringBuilder out, String symbol) {
        out.append(symbol.repeat(WIDTH)).append(System.lineSeparator());
    }

    private void centered(StringBuilder out, String text) {
        if (text.length() >= WIDTH) {
            out.append(text).append(System.lineSeparator());
            return;
        }
        int left = (WIDTH - text.length()) / 2;
        out.append(" ".repeat(left)).append(text).append(System.lineSeparator());
    }
}
