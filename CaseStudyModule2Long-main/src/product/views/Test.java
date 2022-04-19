package product.views;

import product.services.Role.IRoleServiceIMPL;

public class Test {
    public static void main(String[] args) {
        IRoleServiceIMPL iRoleServiceIMPL = new IRoleServiceIMPL();
        iRoleServiceIMPL.findAll();
        RegisterView res = new RegisterView();
        res.RegisterView();
    }
}
