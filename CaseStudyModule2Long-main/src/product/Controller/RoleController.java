package product.Controller;

import product.model.Role;
import product.services.Role.IRoleServiceIMPL;

import java.util.List;

public class RoleController {
    IRoleServiceIMPL roleServiceIMPL = new IRoleServiceIMPL();
    public List<Role> showListRole(){
        return roleServiceIMPL.findAll();
    }

}
