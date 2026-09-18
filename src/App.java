import logic.MenuLogic;

import java.util.Scanner;

public class App {

  static void main() {

    Scanner input = new Scanner(System.in);
    System.out.println("Witaj w aplikacji atlas grzybów!");
    System.out.println("");

    MenuLogic.navigateMenu(MenuLogic.showMenu(input));


  }

}