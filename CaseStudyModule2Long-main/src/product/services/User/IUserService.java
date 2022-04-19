package product.services.User;

import product.model.Product;
import product.model.User;
import product.services.IGenericService;

import java.util.List;

public interface IUserService {
    void add(User newUser);

    void update(int id, User newUser);

    List<User> getUsers();

    boolean existedByUsername(String username);
    boolean checkLogin(String username, String password);
    User findById (int id);
}
