package product.views;

import java.util.Scanner;

public class Sleep extends Thread {
    public void sleep() throws InterruptedException {
        Scanner sc = new Scanner(System.in);

//        RegisterView res = new RegisterView();
//        res.RegisterView();
//        new RegisterView();

        Menu.menuMain2();
//        int choose = sc.nextInt();
        String choose = sc.nextLine();
        switch (choose) {
            case "1":
                System.out.println("-------------------------------------------------------");
                System.out.println("✔ ***    CHÀO MỪNG BẠN ĐẾN THẾ GIỚI GAME LONG   *** ✔ ");
                System.out.println("✔ ***     ...................................   *** ✔ ");
                System.out.println(" --------|   AIR FRANCE - FRANCE IN THE AIR  |-------  ");
                Thread.sleep(400);
                System.out.println("10...");
                Thread.sleep(400);
                System.out.println("9....");
                Thread.sleep(400);
                System.out.println("8.....");
                Thread.sleep(400);
                System.out.println("7......");
                Thread.sleep(400);
                System.out.println("6.......");
                Thread.sleep(400);
                System.out.println("5.........");
                Thread.sleep(400);
                System.out.println("4...........");
                Thread.sleep(400);
                System.out.println("3.............");
                Thread.sleep(400);
                System.out.println("2.............");
                Thread.sleep(400);
                System.out.println("1.............");
                Thread.sleep(600);

                System.out.println("...................................................");
                new RegisterView();
                break;
            case "2":
                System.out.println("✔ ***   Bienvenue à l'utilisateur de Game Long  *** ✔ ");
                System.out.println("✔ ***         (\uD83D\uDC4D ͡❛ ͜ʖ ͡❛)\uD83D\uDC4D (\uD83D\uDC4D ͡❛ ͜ʖ ͡❛)\uD83D\uDC4D        *** ✔");
                System.out.println();
                Thread.sleep(1000);
                System.out.println();
                System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n" +
                        "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                Thread.sleep(400);
                System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n" +
                        "%%%%%%%         %%%           %%%%%           %%%%         #%%%%         %%%%%.  %%%%%%   %%%%  .%       %%       %%%%%%");
                Thread.sleep(400);
                System.out.println("%%%%%%/  %%%%%%%%%%  .%%%%%%  %%%%%  %%%%%%*  %%%%   %%%%%%%%%%%  (%%%%%%%%%%%.  %%%%%%   %%%%     %%%%     %%%   %%%%%%\n" +
                        "%%%%%%/  %%%%%%%%%%  .%%%%%%  %%%%%  %%%%%%*  %%%%         #%%%%  (%%(      %%%           %%%%  .%%%%%%  %%%%%%   %%%%%%" );
                Thread.sleep(400);
                System.out.println("%%%%%%/  %%%%%%%%%%  .%%%%%%  %%%%%  %%%%%%*  %%%%   %%%%%%%%%%% ((((%%%%   %%%%%%%   %%%%%%%%  .%%%%%%  %%%%%%   %%%%%%\n" +
                        "%%%%%%/  %%%%%%%%%%  .%%%%%%  %%%%%  %%%%%%*  %%%%   %%%%%%%%(((( (%%%%%%   %%%%%%%   %%%%%%%%  .%%%%%%  %%%%%%   %%%%%%" );
                Thread.sleep(400);
                System.out.println("%%%%%%%         %%%%          %%%%%          %%%%%%        ((%%%%          %%%%%%%%   %%%%%%%%   %%%%%%  %%%%%%   %%%%%%\n" +
                        "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                Thread.sleep(400);
                System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                System.out.println();
                Thread.sleep(400);
                System.out.println("-------------------------------------------------------");
                System.out.println("✔ ***    CHÀO MỪNG BẠN ĐẾN THẾ GIỚI GAME LONG   *** ✔ ");
                System.out.println("✔ ***     ...................................   *** ✔ ");
                System.out.println(" --------|   AIR FRANCE - FRANCE IN THE AIR  |-------  ");
                Thread.sleep(400);
                System.out.println("10...");
                Thread.sleep(400);
                System.out.println("9....");
                Thread.sleep(400);
                System.out.println("8.....");
                Thread.sleep(400);
                System.out.println("7......");
                Thread.sleep(400);
                System.out.println("6.......");
                Thread.sleep(400);
                System.out.println("5.........");
                Thread.sleep(400);
                System.out.println("4...........");
                Thread.sleep(400);
                System.out.println("3.............");
                Thread.sleep(400);
                System.out.println("2.............");
                Thread.sleep(400);
                System.out.println("1.............");
                Thread.sleep(600);

                System.out.println("...................................................");
                new LoginView();
                break;
            case "3":
                System.out.println("✔ *** L'équipe est ravie de vous accueillir à nouveau !*** ✔ ");
                Thread.sleep(1000);
                System.out.println("-------------------------------------------------------");
                System.out.println("✔ ***    CHÀO MỪNG BẠN ĐẾN THẾ GIỚI GAME LONG   *** ✔ ");
                System.out.println("✔ ***     ...................................   *** ✔ ");
                System.out.println(" --------|   AIR FRANCE - FRANCE IN THE AIR  |-------  ");
                Thread.sleep(400);
                System.out.println("10...");
                Thread.sleep(400);
                System.out.println("9....");
                Thread.sleep(400);
                System.out.println("8.....");
                Thread.sleep(400);
                System.out.println("7......");
                Thread.sleep(400);
                System.out.println("6.......");
                Thread.sleep(400);
                System.out.println("5.........");
                Thread.sleep(400);
                System.out.println("4...........");
                Thread.sleep(400);
                System.out.println("3.............");
                Thread.sleep(400);
                System.out.println("2.............");
                Thread.sleep(400);
                System.out.println("1.............");
                Thread.sleep(600);

                System.out.println("...................................................");
                new ProfileView();
                break;
            case "4":
                System.out.println("5.........");
                Thread.sleep(400);
                System.out.println("4...........");
                Thread.sleep(400);
                System.out.println("3.............");
                Thread.sleep(400);
                System.out.println("2.............");
                Thread.sleep(400);
                System.out.println("1.............");
                Thread.sleep(600);
                System.out.println("✔ *** \uD83D\uDE02 ~  Au Revoir Mes Chers Camarades ~ \uD83D\uDE02  *** ✔ ");
                Thread.sleep(1000);
                return;
        }
    }
}
