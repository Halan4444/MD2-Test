package product.services.Cart;

import data.Path;
import product.model.Cart;
import product.config.CSVUtils;
import product.model.Payment;
import product.model.User;

import java.util.ArrayList;
import java.util.List;

public class CartService implements ICartService {
    List<Cart> cartList = new ArrayList<>();
    public static  String PATH_CART = Path.PATH + " cart.csv";
    public static String path = PATH_CART;

    public List<Cart> findAll(){
        CSVUtils.write(path,cartList);
        return cartList;
    }

    @Override
    public List<Cart> getCart() {
        List<Cart> newCartList = new ArrayList<>();
        List<String> reads = CSVUtils.read(path);
        for (String read : reads) {
            newCartList.add(new Cart(read));
        }
        return cartList = newCartList;
    }

    @Override
    public void updateCart(String name, Cart update) {
        getCart();
        for (int i = 0; i < cartList.size(); i++) {
            if(cartList.get(i).getName().equalsIgnoreCase(name)){
                cartList.set(i,update);
                CSVUtils.write(path,cartList);
            }
        }
    }


    @Override
    public void addCart(Cart newCart) {
        getCart();
        cartList.add(newCart);
        CSVUtils.write(path,cartList);
    }

    @Override
    public void removeCart() {
        cartList.clear();
    }



    public Cart findCartbyID(int id){
        getCart();
        for (Cart cart : cartList) {
            if (cart.getId() == id){
                return cart;
            }
        }
        return null;
    }
    public Cart findCartbyName(String name){
        getCart();
        for (Cart cart : cartList) {
            if (cart.getName().equalsIgnoreCase(name)){
                return cart;
            }
        }
        return null;
    }
    public boolean checkDupblicate(int id){
        for (Cart p :cartList) {
            if (p.getId() == id)
                return true;
        }
        return false;
    }
}

