package product.views;

import java.util.InputMismatchException;
import java.util.Scanner;

public  class Menu {
    static ProductView productView = new ProductView();
   static PaymentView paymentView = new PaymentView();
   static Scanner scanner = new Scanner(System.in);

    public static void boss(){
        menuBoss();
        try {
            System.out.println("\nChọn chức năng ");
            System.out.print("\t➺ ");
            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    productView.showProductBoss();
                    break;
                case 2:
                    productView.showProductDescriptionBoss();
                    break;
                case 3:
                    productView.add();
                    break;
                case 4:
                    productView.updateProduct();
                    break;
                case 5:
                    productView.findProductbyNameBoss();
                    break;
                case 6:
                    productView.findProductbyTypeBoss();
                    break;
                case 7:
                    paymentView.showAllIncome();
                    break;
                case 8:
                    chon1();
                    break;
                case 9:
                    exit();
                    break;
                default:
                    System.out.println("▲ Chọn chức năng không đúng! Vui lòng chọn lại ▲");
                    boss();
            }
        } catch (Exception e) {
            System.out.println("Nhập sai! vui lòng nhập lại");
            boss();
        }
    }

    public static void guest() {
        menuGuest();
        try {
            System.out.println("\nChọn chức năng ");
            System.out.print("\t➺ ");
            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    productView.showProductGuest();
                    break;
                case 2:
                    productView.showProductDescriptionGuest();
                    break;
                case 3:
                    productView.findProductbyNameGuest();

                    break;
                case 4:
                    productView.findProductbyTypeGuest();
                    break;
                case 5:
                    productView.sortASC();
                    break;
                case 6:
                    productView.sortDESC();
                    break;
                case 7:
                    paymentView.buy();
                    break;
                case 8:
                    chon1();
                    break;
                case 9:
                    exit();
                    break;
                default:
                    System.out.println("▲ Chọn chức năng không đúng! Vui lòng chọn lại ▲");
                    guest();
            }
        } catch (Exception e) {
            System.out.println("Nhập sai! vui lòng nhập lại");
            guest();
        }
    }

    public static void chon() {
        do {
            menuMain();
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("\nChọn chức năng ");
                System.out.print("\t➺ ");
                int number = scanner.nextInt();
                switch (number) {
                    case 1:
                        boss();
                        break;
                    case 2:
                        guest();
                        break;
                    case 3:
                        exit();
                        break;
                    default:
                        System.out.println("▲ Chọn chức năng không đúng! Vui lòng chọn lại ▲");
                        chon();
                }

            } catch (InputMismatchException io) {
                System.out.println("Nhập sai! Vui lòng nhập lại");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public static void chon1() {
        do {
            menuMain2();
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("\n CHÀO MỪNG GUEST ");
                System.out.print("\t➺ ");
                int number = scanner.nextInt();
                switch (number) {
                    case 1:
                        new RegisterView();
                        break;
                    case 2:
                        new LoginView();
                        break;
                    case 3:
                        new ProfileView();
                        break;
                    case 4:
                        exit();
                    default:
                        System.out.println("▲ Chọn chức năng không đúng! Vui lòng chọn lại ▲");
                        chon1();
                }

            } catch (InputMismatchException io) {
                System.out.println("Nhập sai! Vui lòng nhập lại");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public static void menuMain2() {
        System.out.println();
        System.out.println("* * * * GIAO DIỆN TRUY CẬP  * * *");
        System.out.println("*                               *");
        System.out.println("*      ⌛ 1.    CREATE ACCOUNT   *");
        System.out.println("*      ✍ 2.    LOGIN            *");
        System.out.println("*      ⌛ 3.    BACK TO GAME     *");
        System.out.println("*      ✍ 4.    EXIT             *");
        System.out.println("*                               *");
        System.out.println("* * * * * * * * * * * * * * * * *");
    }

    public static void menuMain() {
        System.out.println();
        System.out.println("* * * * --GIAO DIỆN GUEST-- * * *");
        System.out.println("*                               *");
        System.out.println("*       1.    ADMIN             *");
        System.out.println("*       2.    USER              *");
        System.out.println("*       3.    BACK TO GAME      *");
        System.out.println("*       4.    EXIT              *");
        System.out.println("*                               *");
        System.out.println("* * * * * * * * * * * * * * * * *");
    }

    public static void exit() {
        System.out.println("\t\t\t\t\t\t \uD83D\uDE09 Merci Beaucoup Monsieur \uD83D\uDE09");
        System.out.println("\t\t\t\t\t\t ✌ Au Revoir Monsieur ✌");

        System.exit(0);
    }

    public static void menuBoss() {
        System.out.println("⚪ ⚪ ⚪ ⚪ ⚪  GIAO DIỆN ADMIN  ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪");
        System.out.println("⚪                                               ⚪");
        System.out.println("⚪     1. Hiển thị danh sách sản phẩm            ⚪");
        System.out.println("⚪     2. Hiển thị mô tả sản phẩm                ⚪");
        System.out.println("⚪     3. Thêm sản phẩm vào danh sách            ⚪");
        System.out.println("⚪     4. Sửa thông tin sản phẩm                 ⚪");
        System.out.println("⚪     5. Tìm kiếm sản phẩm theo tên             ⚪");
        System.out.println("⚪     6. Tìm kiếm sản phẩm theo loại            ⚪");
        System.out.println("⚪     7. Xem tổng doanh thu                     ⚪");
        System.out.println("⚪     8. Return                                 ⚪");
        System.out.println("⚪     9. Exit                                   ⚪");
        System.out.println("⚪                                               ⚪");
        System.out.println("⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪  ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪");
    }

    public static void menuGuest() {
        System.out.println("⚪ ⚪ ⚪ ⚪ ⚪   GIAO DIỆN USER  ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪");
        System.out.println("⚪                                             ⚪");
        System.out.println("⚪     1. Hiển thị danh sách sản phẩm          ⚪");
        System.out.println("⚪     2. Hiển thị mô tả sản phẩm              ⚪");
        System.out.println("⚪     3. Tìm kiếm sản phẩm theo tên           ⚪");
        System.out.println("⚪     4. Tìm kiếm sản phẩm theo loại          ⚪");
        System.out.println("⚪     5. Sắp xếp sản phẩm theo giá tăng dần   ⚪");
        System.out.println("⚪     6. Sắp xếp sản phẩm theo giá giảm dần   ⚪");
        System.out.println("⚪     7. Mua sản phẩm                         ⚪");
        System.out.println("⚪     8. Return                               ⚪");
        System.out.println("⚪     9. Exit                                 ⚪");
        System.out.println("⚪                                             ⚪");
        System.out.println("⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪");
    }

}
