import logic.MushroomCreator;
import logic.MenuLogic;
import logic.MushroomSearcher;
import model.MushroomList;

import java.util.Scanner;

public class App {

  static void main() {



    System.out.println("Witaj w aplikacji atlas grzybów!");
    System.out.println("");

    MushroomList mushroomList = new MushroomList();
    Scanner scanner = new Scanner(System.in);


    MushroomCreator mushroomCreator = new MushroomCreator(mushroomList, scanner);
    MushroomSearcher mushroomSearcher = new MushroomSearcher(scanner, mushroomList);
    MenuLogic menuLogic = new MenuLogic(scanner, mushroomCreator, mushroomSearcher);


    menuLogic.runMenu();

    scanner.close();
  }
}