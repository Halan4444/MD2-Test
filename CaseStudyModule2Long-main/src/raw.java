//public void setPType(Product product) {
//        System.out.println("=       = SET TYPE =     =");
//        System.out.println("∥   1. SKINCARE          ∥");
//        System.out.println("∥   2. BODYCARE          ∥");
//        System.out.println("∥   3. HAIRCARE          ∥");
//        System.out.println("∥   4. LIPCARE           ∥");
//        System.out.println("∥   5. FUNCTIONALFOODS   ∥");
//        System.out.println("= = = = = = = = = = = = = ");
//        System.out.println("Chọn Role: ");
//        System.out.print(" ⭆ ");
//        int chido;
//        try {
//        chido = Integer.parseInt(scanner.nextLine());
//        switch (chido) {
//        case -1:
//        break;
//        case 1:
//        product.setType(PType.SKINCARE);
//        break;
//        case 2:
//        product.setType(PType.BODYCARE);
//        break;
//        case 3:
//        product.setType(PType.HAIRCARE);
//        break;
//        case 4:
//        product.setType(PType.LIPCARE);
//        break;
//        case 5:
//        product.setType(PType.FUNCTIONALFOODS);
//        break;
//default:
//        System.out.println("Nhập không đúng! Vui lòng nhập lại");
//        setPType(product);
//        }
//        } catch (Exception e){
//        System.out.println("\t ❌ Lựa chọn phải là 1 số ❌");
//        System.out.println("\t=========================");
//        setPType(product);
//        }
//        }