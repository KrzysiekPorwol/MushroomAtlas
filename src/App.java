import logic.MakeMushroom;
import logic.MenuLogic;
import logic.SearchMushroom;
import model.Mushroom;
import model.MushroomList;

import java.util.Scanner;

public class App {

  static void main() {



    System.out.println("Witaj w aplikacji atlas grzybów!");
    System.out.println("");

    MushroomList mushroomList = new MushroomList();
    Scanner scanner = new Scanner(System.in);


    MakeMushroom makeMushroom = new MakeMushroom(mushroomList, scanner);
    SearchMushroom searchMushroom = new SearchMushroom(scanner, mushroomList);
    MenuLogic menuLogic = new MenuLogic(scanner, makeMushroom, searchMushroom);


    menuLogic.runMenu();

    scanner.close();
  }
}