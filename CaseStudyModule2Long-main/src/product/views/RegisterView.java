package product.views;

import product.Controller.UserController;
import product.config.ValidateUtils;
import product.dto.SignUpDTO;
import product.model.Role;
import product.model.RoleName;
import product.model.User;
import product.model.UserPrincipal;
import product.services.Role.IRoleServiceIMPL;
import product.services.User.IUserServiceIMPL;
import product.services.UserPrincipal.IUserPrincipal;
import product.services.UserPrincipal.IUserPrincipalIMPL;

import java.util.*;

public class RegisterView {
    IUserServiceIMPL userServiceIMPL = new IUserServiceIMPL();
    IRoleServiceIMPL iRoleServiceIMPL = new IRoleServiceIMPL();
    UserController userController = new UserController();
    Scanner scanner = new Scanner(System.in);
    public  RegisterView() {
        System.out.println("              ===== REGISTER FORM =====");
        System.out.println();
        System.out.println("✔ ***   CUỘC SỐNG KHÓ KHĂN CÒN NHIỀU TRẮC TRỞ   *** ✔");
        System.out.println("✔ ***     NHƯNG TÌNH NGƯỜI LUÔN CÓ Ở MỌI NƠI    *** ✔");
        System.out.println("✔ ***  XUNG QUANH TA CÒN NHIỀU CODE THỦ LỆ RƠI  *** ✔");
        System.out.println("✔ *** ĐÓ LÀ DO BẠN CHƯA MUA GAME ĐÓ,NGƯỜI LẠ ƠI *** ✔");
        System.out.println();
        System.out.println("        |    > WELCOME TO LONGFRANCE GAME <   |");
        System.out.println();
        System.out.println("        |    > HƯỚNG DẪN ĐĂNG KÝ TÀI KHOẢN <  |");
        System.out.println();
        System.out.println("        | Để có thể mua sản phẩm trên hệ thống |");
        System.out.println("        | Bạn cần đăng ký tài khoản, sau đó    |");
        System.out.println("        | Khai báo 1 số thông tin cá nhân      |");
        System.out.println("        | Khác như sdt, email và địa chỉ nhà   |");
        System.out.println("        | Cuối cùng là nạp tiền vào tài khoản  |");
        System.out.println("        | BIDV:4501005624399 - NGUYEN TIEN LONG|");
        System.out.println("        | Mỗi lần nạp Game bạn sẽ đổi tiền thực|");
        System.out.println(" | Thành tiền ảo để mua những thứ tất nhiên là Không có thực|");
        System.out.println(" | SOng tiền bạc không quan trọng, của nhiều lòng ít là được|");
        System.out.println();



        System.out.println("|      > BẮT ĐẦU KHAI BÁO  <   |");



//        System.out.println("||      Nhập Tên Tài Khoản      ||");
        String username;
        while (true) {
            System.out.println("||      Nhập Tên Tài Khoản      ||");
            String check = scanner.nextLine();
            if (userServiceIMPL.existedByUsername(check)) {
                System.out.println(" ❌ Tên này đã tồn tại xin nhập tên khác ❌");
            } else {
               username = check;
                break;
            }
        }

        System.out.println("||      Nhập Họ Và Tên          ||");
        String name = scanner.nextLine();
        System.out.println("||      Nhập Mật Khẩu           ||");
        String password = scanner.nextLine();
        while (!ValidateUtils.isPasswordValid(password)) {
            System.out.println("Số " + password + " của bạn không đúng định dạng. Vui lòng nhập lại! \n" + "(Mật khẩu gồm 6 chữ số trở lên và phải có 1 ký tự số, 1 ký tự đặc biệt )");
            System.out.println("Nhập số điện thoại (vd: 0971789396)");
            System.out.print("\t➺ ");
            password = scanner.nextLine();
        }
        String role = "user";
        Set<String> strRole = new HashSet<>();
        strRole.add(role);
        SignUpDTO signUpDTO = new SignUpDTO(name,username,password,strRole);
        userController.register(signUpDTO)
        ;
       new LoginView();
    }
}
