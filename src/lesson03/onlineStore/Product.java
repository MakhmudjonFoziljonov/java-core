package lesson03.onlineStore;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@RequiredArgsConstructor
public class Product {
    private final String code;
    private final String name;
    private final BigDecimal price;
    private  int count = 15;

    public void buy(int qty) {
        if (qty <= 0) throw new IllegalArgumentException("qty must be > 0");
        if (count < qty) throw new IllegalStateException("Not enough items in stock");
        count -= qty;
    }

    public String getProductInfo() {
        return String.format("Product" +
                "{" +
                "code='%s', name='%s', price=%s, count=%d" +
                "}",
            code, name, price, count);
    }

    @Override
    public String toString() {
        return getProductInfo();
    }
}
