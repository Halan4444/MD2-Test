package product.views;

import product.Controller.UserController;
import product.dto.SignInDTO;

import java.util.Scanner;

public class LoginView { ;
    Scanner scanner = new Scanner(System.in);
    UserController userController = new UserController();

    public LoginView()  {
        System.out.println("---||        ❤ LOGIN FORM ❤       ||---");
        System.out.println("---||      Nhập tên tài khoản      ||---");
        String username = scanner.nextLine();
        System.out.println("---||        Nhập Mật Khẩu         ||---");
        String password = scanner.nextLine();
        SignInDTO signIn = new SignInDTO(username, password);
        if (userController.login(signIn)) {
            new ProfileView();
        } else if (loginAdmin(signIn)) {
            Menu.boss();
        }
        else {
            System.err.println("➧ Login failed! Please check username or password! ➧");
            new LoginView();
        }
    }

    public boolean loginAdmin(SignInDTO signIn) {
        if ("Admin".equals(signIn.getUsername()) && "AnhChinhVoDich".equals(signIn.getPassword())) {
            return true;
        }
        return false;
    }
}
