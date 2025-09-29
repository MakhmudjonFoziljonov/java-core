package lesson03.onlineStore;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;

@Getter
@Setter
public class ProductService implements ProductRepository {
    private final Map<String, Product> map = new HashMap<>();

    @Override
    public void addProduct(Product product) {
        Objects.requireNonNull(product, "product required");
        Product prev = map.putIfAbsent(product.getCode(), product);
        if (prev != null) {
            throw new IllegalArgumentException("Product with code already exists: " + product.getCode());
        }
    }

    @Override
    public void buyProduct(String code, int qty) {
        Product product = map.get(code);
        if (product == null) throw new NoSuchElementException("Product not found: " + code);
        product.buy(qty);
    }

    @Override
    public String getProductInfo(String code) {
        Product product = map.get(code);
        if (product == null) throw new NoSuchElementException("Product not found: " + code);
        return product.getProductInfo();
    }

    @Override
    public List<Product> getProducts() {
        return new ArrayList<>(map.values());
    }
}
