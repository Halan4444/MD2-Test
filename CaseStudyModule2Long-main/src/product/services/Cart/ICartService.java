package product.services.Cart;

import product.model.Cart;

import java.util.List;

public interface ICartService {
    List <Cart> getCart();
    void updateCart(String name,Cart update);
    void addCart (Cart newCart);
     void removeCart();

}
