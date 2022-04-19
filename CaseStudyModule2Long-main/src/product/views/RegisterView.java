package product.views;

import product.dto.SignUpDTO;
import product.model.Role;
import product.model.RoleName;
import product.model.User;
import product.model.UserPrincipal;
import product.services.Role.IRoleServiceIMPL;
import product.services.User.IUserServiceIMPL;
import product.services.UserPrincipal.IUserPrincipalIMPL;

import java.util.*;

public class RegisterView {
    IUserServiceIMPL userServiceIMPL = new IUserServiceIMPL();
    IRoleServiceIMPL iRoleServiceIMPL = new IRoleServiceIMPL();
    Scanner scanner = new Scanner(System.in);
    public void RegisterView() {
        int id;
        if (IUserServiceIMPL.userList.size()==0) {
            id =1;
        } else {
            id = IUserServiceIMPL.userList.get(IUserServiceIMPL.userList.size()-1).getId()+1;
        }
        System.out.println("||      Nhập tên tài khoản      ||");
        String username = scanner.nextLine();
        System.out.println("||      Nhập mật khẩu           ||");
        String password = scanner.nextLine();
        List<UserPrincipal> userPrincipalList = IUserPrincipalIMPL.userPrincipalList;
        Set<Role> roleSet = userPrincipalList.get(0).getRoleSet();
        List<Role> roleList = new ArrayList<>(roleSet);
        boolean checkAdmin = roleList.get(0).getName() == RoleName.ADMIN;
        Set<Role> roleSet = new HashSet<>();
        Role adminRole = iRoleServiceIMPL.findByName(RoleName.USER);
        roleSet.add(adminRole);
        User user = new User(id,username, password,roleSet);
        userServiceIMPL.userList.add(user);
        System.out.println(user);
        String role = "user";
        Set<String> strRole = new HashSet<>();
        strRole.add(role);
        SignUpDTO signUpDTO = new SignUpDTO(name,username,password,strRole);
        userController.register(signUpDTO);new RegisterView();
    }
}
