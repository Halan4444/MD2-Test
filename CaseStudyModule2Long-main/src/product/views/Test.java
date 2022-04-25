package product.views;

import product.services.Role.IRoleServiceIMPL;

import java.util.Scanner;

public class Test extends Thread {
    public Test (){
        Sleep sleep = new Sleep();
        try {
            sleep.sleep();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        new Test();

        }

//        new Menu();

}
