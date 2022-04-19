package product.services.Product;

import product.model.Product;

import java.nio.file.Path;
import java.util.List;

public interface IProductService {
    void add(Product newProduct);

    void update(int id, Product updateProduct);

    List<Product> getProducts();

    void updateQuantity(int id, int quantity);

}
