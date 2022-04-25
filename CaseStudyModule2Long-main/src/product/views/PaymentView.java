package product.views;

import product.model.*;
import product.services.Cart.CartService;
import product.services.Payment.PaymentService;
import product.services.Product.ProductService;
import product.config.ValidateUtils;
import product.services.User.IUserServiceIMPL;
import product.services.UserPrincipal.IUserPrincipalIMPL;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PaymentView {
    DecimalFormat format = new DecimalFormat("###,###,###" + " đ");
    Scanner scanner = new Scanner(System.in);
    PaymentService paymentService = new PaymentService();
    ProductService productService = new ProductService();
    List<Payment> list = new ArrayList<>();
    List<Cart> cartList = new ArrayList<>();
    IUserServiceIMPL userServiceIMPL = new IUserServiceIMPL();
    IUserPrincipalIMPL userPrincipalIMPL = new IUserPrincipalIMPL();
    Menu menu = new Menu();
    int id1 = 0;
    int id2 = 0;
    int quantityPurchased = 0;
    int quantityPurchased1 = 0;
    int rawQuantity;
    int quantityDuplicate;
    int quantityNonDuplicate;
    String name;
    String phone;
    String address;
    long revenue;
    int realQuantity;
    int quantity;
    int quantity1;
    int currentQuantity;

    CartService cartService = new CartService();


    Product product = null;
    Payment payment = null;

    public PaymentView() {
    }

    public void test() {
        paymentService.existProduct(3);

    }


    public void buy() {
        while (true) {
            System.out.println("Nhập ID sản phẩm cần mua");
            System.out.print("\t➺ ");
            try {
                id1 = Integer.parseInt(scanner.nextLine());
                if (id1 > 0) {
                    if (paymentService.existProduct(id1)) {
                        product = paymentService.findProductbyID(id1);
                        break;
                    } else {
                        System.out.println("ID này không tồn tại");
                    }
                } else {
                    System.out.println("\t ❌ ID phải lớn hơn 0 ❌");
                    System.out.println();
                }
            } catch (Exception e) {
                System.out.println("\t ❌ ID phải là 1 số ❌");
                System.out.println();
            }
        }
        while (true) {
            System.out.println("Nhập số lượng sản phẩm: ");
            System.out.print("\t➺ ");
            realQuantity = product.getQuantity();
            try {
                quantity = Integer.parseInt(scanner.nextLine());
                if (quantity >= 0) {
                    if (!(quantity > realQuantity)) {
                        currentQuantity = realQuantity - quantity;
                        quantityPurchased = quantity;
                        break;
                    } else {
                        System.out.println("❌ Vượt quá số lượng hàng có sẵn ❌");
                        System.out.println();
                    }
                } else {
                    System.out.println("\t ❌ Số lượng phải lớn hơn 0 ❌");
                    System.out.println();
                }
            } catch (Exception e) {
                System.out.println("\t ❌ Số lượng phải là 1 số ❌");
                System.out.println();
            }
        }
        long price = product.getPrice();
        revenue = price * quantityPurchased;
        Payment p = new Payment(id1, quantityPurchased, revenue);
        if(list.size()==0){
            list.add(p);
        } else {
            boolean isUpdate = false;
            boolean isError = false;
            for (Payment t : list) {
               int x =  t.getId();
               if (x == id1){
                   if (quantityPurchased + t.getQuantity() > realQuantity){
                       isError = true;
                       break;
                   } else {
                       t.setRevenue(t.getQuantity()* price);
                       t.setQuantity(quantityPurchased + t.getQuantity());
                       isUpdate = true;
                   }
               }
            }
            if(isError){
                System.out.println("❌ Vượt quá số lượng hàng có sẵn ❌");
                System.out.println();
                buy();
            } else if (!isUpdate){
                list.add(p);
            }
        }

        int id;
        id = IUserPrincipalIMPL.findAll().get(0).getId();
        User user = userServiceIMPL.getUsers().get(id-1);
        name = user.getName();
        Cart cart = new Cart(id1,name,quantity,product.getName(),"CHƯA MUA HÀNG");

        cartService.addCart(cart);
        System.out.println("Giỏ Hàng Của: "+name );
        List<Cart> cartLists = cartService.getCart();
//        System.out.println(cartService.findCartbyName(name).getName());
        System.out.println("...");
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("......");
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("\t\t\t\t%-10s %-2s %-15s %-2s %-10s %-2s %-25s %-2s %-10s \n",
                "ID SP","|","KHÁCH HÀNG","|","SỐ LƯỢNG","|", "TÊN SẢN PHẨM","|","TRẠNG THÁI");
        for (int i =0; i<cartLists.size();i++){
            if (name.equals(cartLists.get(i).getName())){
                System.out.printf("\t\t\t\t%-10s %-2s %-15s %-2s %-10s %-2s %-25s %-2s %-10s\n",
                        cartLists.get(i).getId(),"|", cartLists.get(i).getName(),"|", cartLists.get(i).getQuantity(),"|", cartLists.get(i).getProductName(),"|", cartLists.get(i).getStatus());
//                System.out.println("Có Vào không ?");
            }
        }

        option();
    }

    public void showTotal() {
        System.out.println("Danh sách sản phẩm mua");
        System.out.println("______________________");
        long sum = 0;
        for (int i = 0; i < list.size(); i++) {
            long total;
            total = list.get(i).getQuantity() * productService.findProductbyID(list.get(i).getId()).getPrice();
            System.out.printf("Tổng tiền sản phẩm %s là : %s\n", productService.findProductbyID(list.get(i).getId()).getName(), format.format(total));
            sum += total;

        }
        System.out.println("________________________________________");
        System.out.println(" ☛ Số tiền cần thanh toán: " + format.format(sum));
        System.out.println("________________________________________");
        check();
    }

    public void showInformation(){
        System.out.println("Thông tin đơn hàng");
        System.out.println("__________________");
        System.out.println("Tên khách hàng: "+ list.get(0).getName());
        System.out.println("Số điện thoại: "+ list.get(0).getPhoneNumber());
        System.out.println("Địa chỉ: "+ list.get(0).getAddress());
        System.out.println("Danh sách sản phẩm mua");
        long sum = 0;
        for (int i = 0; i < list.size(); i++) {
            long total;
            total = list.get(i).getQuantity() * productService.findProductbyID(list.get(i).getId()).getPrice();
            System.out.printf("Tổng tiền sản phẩm %s là : %s\n", productService.findProductbyID(list.get(i).getId()).getName(), format.format(total));
            sum += total;

        }
        System.out.println("________________________________________");
        System.out.println("Số tiền cần thanh toán: " + format.format(sum));
        System.out.println("________________________________________");
        afterPay();
    }

    public void showAllIncome (){
        System.out.println("===================================");
        System.out.println("＄ Tổng doanh thu: "+ format.format(paymentService.showTotal()));
        System.out.println("===================================");
        menu.boss();
    }

    public void option() {
        System.out.println("nhập 1 để mua thêm sản phẩm");
        System.out.println("nhập 2 để xem tổng tiền");
        System.out.print("\t➺ ");
        int options;
        try {
            options = Integer.parseInt(scanner.nextLine());
            switch (options) {
                case 1:
                    buy();
                    break;
                case 2:
                    showTotal();
                    break;
                default:
                    System.out.println("Nhập không đúng! Vui lòng nhập lại");
                    option();
            }
        } catch (Exception e) {
            System.out.println("\t ❌ lựa chọn phải là 1 số ❌");
            System.out.println();
            option();

        }
    }

    public void check() {
        System.out.println("Bạn có muốn thanh toán đơn hàng máy bay này không?");
        System.out.println("nhập 1 để thanh toán");
        System.out.println("nhập 2 để mua lại");
        System.out.print("\t➺ ");
        String options;
        try {
//            options = Integer.parseInt(scanner.nextLine());
            options = scanner.nextLine();
            switch (options) {
                case "1":
                    pay();
                    return;
                case "2":
                    list.clear();
                    buy();
                    break;
                default:
                    System.out.println("Nhập không đúng! Vui lòng nhập lại");
                    check();
            }
        } catch (Exception e) {
            System.out.println("\t ❌ lựa chọn phải là 1 số ❌");
            System.out.println();
            check();
        }
    }

    public void pay() {
        System.out.println("       ☟ THÔNG TIN NHẬP TỰ ĐỘNG  ☟");
        System.out.println("∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘");
        System.out.println("============== MY NAVBAR ===============");
//        name = scanner.nextLine();
        System.out.println("...");
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("......");
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("...........");
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("................");
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("...............................");
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("...............ok.ok.ok.ok.................");
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        int id;
        id = IUserPrincipalIMPL.findAll().get(0).getId();
        User user = userServiceIMPL.getUsers().get(id-1);
        name = user.getName();
//        System.out.println(name);

//        while (!ValidateUtils.isNameValid(name)) {
//            System.out.println("Tên " + name + "không đúng định dạng." + " Vui lòng nhập lại!" + " (Tên phải viết hoa chữ cái đầu và không dấu)");
//            System.out.println("Nhập tên (vd: Anh Nguyen) ");
//            System.out.print("\t➺ ");
//            name = scanner.nextLine();
//        }
        System.out.print("\t➺ ");
        System.out.println("Tên bạn là: "+name);
        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(".......................");

        phone = user.getPhoneNumber();
//        phone = scanner.nextLine();
        while (!ValidateUtils.isPhoneValid(phone)) {
            System.out.println("Số " + phone + " của bạn không đúng định dạng. Vui lòng nhập lại! " + "(Số điện thoại bao gồm 10 số và bắt đầu là số 0)");
            System.out.println("Nhập số điện thoại (vd: 0971789396)");
            System.out.print("\t➺ ");
            phone = scanner.nextLine();
        }
        System.out.print("\t➺ ");
        System.out.println("SDT của bạn là: "+phone);
        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(".......................");


        address = user.getAddress();
//        while (!ValidateUtils.isAddreeValid(address)) {
//            System.out.println("Nhập địa chỉ ");
//            System.out.print("\t➺ ");
//            address = scanner.nextLine();
//        }
        System.out.print("\t➺ ");
        System.out.println("Địa chỉ của bạn là: "+address);
        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(".......................");
        for (Payment p : list) {
            p.setName(name);
            p.setPhoneNumber(phone);
            p.setAddress(address);
        }
        paymentService.add(list);
        for (Payment u : list) {
            int a = u.getId();
            int c =u.getQuantity();
            int b = productService.getQuantity(a);
            productService.updateQuantity(a,b-c);
        }
        productService.checkExist();
        System.out.println("thanh toán thành công");
        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(".......................");
        List<Cart> cartLists = cartService.getCart();
        name = user.getName();
        System.out.printf("\t\t\t\t%-10s %-2s %-15s %-2s %-10s %-2s %-25s %-2s %-10s \n",
                "ID SP","|","KHÁCH HÀNG","|","SỐ LƯỢNG","|", "TÊN SẢN PHẨM","|","TRẠNG THÁI");
        for (int i =0; i<cartLists.size();i++){
            if (name.equals(cartLists.get(i).getName())){
                cartLists.get(i).setStatus("ĐÃ MUA HÀNG");
                System.out.printf("\t\t\t\t%-10s %-2s %-15s %-2s %-10s %-2s %-25s %-2s %-10s\n",
                        cartLists.get(i).getId(),"|", cartLists.get(i).getName(),"|", cartLists.get(i).getQuantity(),"|", cartLists.get(i).getProductName(),"|",cartLists.get(i).getStatus());
//                cartService.removeCart();
//                if (name.equals(cartLists.get(i).getName())&&cartLists.get(i).getStatus().equalsIgnoreCase("CHƯA MUA HÀNG")) {
//                    cartService.addCart(cartLists.get(i));
//                }
                for (int j =0; j<cartLists.size();j++) {
                    if (name.equalsIgnoreCase(cartLists.get(j).getName())) {
                        cartService.updateCart(cartLists.get(j).getName(),cartLists.get(j));
                    }
                }

            }
        }
        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(".......................");

        afterPay();

    }



    public void afterPay() {
        System.out.println("Bạn có muốn kiểm tra thông tin thanh toán không?");
        System.out.println("nhập 1 để xem thông tin thanh toán");
        System.out.println("nhập 2 để quay lại menu");
        System.out.println("nhập 3 để theo dõi biến động thị trường máy bay trên Server Game Long");
        System.out.println("Sau Khi Thanh Toán Giỏ Hàng Sẽ Được Xóa");

        System.out.print("\t➺ ");
        int options;
        try {
            options = Integer.parseInt(scanner.nextLine());
            switch (options) {
                case 1:
                    showInformation();
                    break;
                case 2:
                    menu.guest();
                    break;
                case 3:
                    System.out.println("∼∼∼∼∼∼∼∼∼∼Coming soon∽∽∽∽∽∽∽∽∽∽");
                    menu.exit();
                    break;
                default:
                    System.out.println("Nhập không đúng! Vui lòng nhập lại");
                    check();
            }
        } catch (Exception e) {
            System.out.println("\t ❌ lựa chọn phải là 1 số ❌");
            System.out.println();
            check();
        }
    }


}
