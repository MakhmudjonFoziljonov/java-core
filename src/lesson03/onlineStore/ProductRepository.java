package lesson03.onlineStore;


import java.util.List;

public interface ProductRepository {
    void addProduct(Product product);
    void buyProduct(String code, int qty);
    String getProductInfo(String code);
    List<Product> getProducts();
}
