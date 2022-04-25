package product.Controller;

import product.config.ValidateUtils;
import product.dto.SignInDTO;
import product.dto.SignUpDTO;
import product.model.Role;
import product.model.RoleName;
import product.model.User;
import product.model.UserPrincipal;
import product.services.Role.IRoleServiceIMPL;
import product.services.User.IUserServiceIMPL;
import product.services.UserPrincipal.IUserPrincipalIMPL;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class UserController {
    IUserServiceIMPL userServiceIMPL = new IUserServiceIMPL();
    IRoleServiceIMPL roleServiceIMPL = new IRoleServiceIMPL();
    IUserPrincipalIMPL userPrincipalIMPL = new IUserPrincipalIMPL();

    public List<User> showListUse() { return userServiceIMPL.findAll();}

    public void register(SignUpDTO signUp)  {
        Scanner scanner = new Scanner(System.in);

//        userServiceIMPL.getUsers();
            int id;
            if (userServiceIMPL.getUsers().size()==0) {
                id =1;
            } else {
                id = userServiceIMPL.userList.get(userServiceIMPL.userList.size()-1).getId()+1;
            }
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
            });
        System.out.println("✔ *** You Have Successfully Registered *** ✔");
        System.out.println("✔ ***     Bạn Đã Đăng Ký Thành Công    *** ✔");


        System.out.println("  ☟ ** Nhập thông tin cá nhân lưu tài khoản ** ☟");
        System.out.println("∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘");
        System.out.println();
        String phone ;
        System.out.println("Nhập số điện thoại (vd: 0971789396): ");
        System.out.print("\t➺ ");
        phone = scanner.nextLine();

        while (!ValidateUtils.isPhoneValid(phone)) {
            System.out.println("Số " + phone + " của bạn không đúng định dạng. Vui lòng nhập lại! \n" + "(Số điện thoại bao gồm 10 số và bắt đầu là số 0)");
            System.out.println("Nhập số điện thoại (vd: 0971789396)");
            System.out.print("\t➺ ");
            phone = scanner.nextLine();
        }
        System.out.println();
        System.out.println("Nhập địa chỉ (vd: Hà Nội)");
        System.out.print("\t➺ ");
        String address = scanner.nextLine();
        while (!ValidateUtils.isAddreeValid(address)) {
            System.out.println("Nhập địa chỉ ");
            System.out.print("\t➺ ");
            address = scanner.nextLine();
        }
        System.out.println();
        System.out.println("Nhập địa chỉ Email");
        System.out.println("NHập vào theo mẫu username@domain.com ");
        System.out.print("\t➺ ");
        String email = scanner.nextLine();
        while (!ValidateUtils.isEmailValid(email)) {
            System.out.println("Nhập địa chỉ Email ");
            System.out.print("\t➺ ");
            email = scanner.nextLine();
        }

            User user = new User(id, signUp.getUsername(), signUp.getPassword(), signUp.getName(), phone, email, address, RoleName.USER.getValue());
            userServiceIMPL.add(user);

        System.out.println("|--------------------------------------------|");
        System.out.println("|    SOLD!!!  \\ (^ 3 ^) /  ~ (^ . ^) ~      |");
        System.out.println("|                                            |");
        System.out.println("|  THANKS YOU FOR USING LONG SMART MARKET    |");
        System.out.println("|--------------------------------------------|");

//            Scanner input = new Scanner(System.in);
//            System.out.println("Nhập ID sản account: ");
//            System.out.print("\t➺ ");
//            id = input.nextInt();


    }
    public boolean login (SignInDTO signIn) {
        if (userServiceIMPL.checkLogin(signIn.getUsername(),signIn.getPassword())) {
            User user = userServiceIMPL.findByUsername(signIn.getUsername());
            UserPrincipal userPrincipal = new UserPrincipal(user.getId(), user.getName(), user.getUsername(), user.getPassword(),user.getRoles());
            userPrincipalIMPL.add(userPrincipal);
            return true;
        } else {
            return  false;
        }
    }
}
