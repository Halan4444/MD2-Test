package product.Controller;

import product.dto.SignUpDTO;
import product.model.Role;
import product.model.RoleName;
import product.model.User;
import product.services.Role.IRoleServiceIMPL;
import product.services.User.IUserServiceIMPL;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserController {
    IUserServiceIMPL userServiceIMPL = new IUserServiceIMPL();
    IRoleServiceIMPL roleServiceIMPL = new IRoleServiceIMPL();

    public List<User> showListUse() { return userServiceIMPL.findAll();}

    public void register(SignUpDTO signUp) {
        int id;
        if (IUserServiceIMPL.userList.size()==0) {
            id =1;
        } else {
            id = IUserServiceIMPL.userList.get(IUserServiceIMPL.userList.size()-1).getId()+1;
        }
        System.out.println(signUp.getStrRole());
        System.out.println("Có vào hay không");
        Set<String> strRole = signUp.getStrRole();
        Set<Role> roleSet = new HashSet<>();
        strRole.forEach(role -> {
            switch (role) {
                case "admin":
                    Role adminRole = roleServiceIMPL.findByName(RoleName.ADMIN);
                    roleSet.add(adminRole);
                    break;
                case "user":
                    Role userRole = roleServiceIMPL.findByName(RoleName.USER);
                    roleSet.add(userRole);
                    break;
            }
            User user = new User(id, signUp.getUsername(), signUp.getPassword(), roleSet);
            userServiceIMPL.add(user);
        });

    }
}
