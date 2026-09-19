import logic.MakeMushroom;
import logic.MenuLogic;
import model.MushroomList;

import java.util.Scanner;

public class App {

  static void main() {

    System.out.println("Witaj w aplikacji atlas grzybów!");
    System.out.println("");

    MushroomList mushroomList = new MushroomList();
    Scanner input = new Scanner(System.in);

    MenuLogic menuLogic = new MenuLogic(mushroomList, input);

    menuLogic.runMenu(input);


    input.close();
  }
}