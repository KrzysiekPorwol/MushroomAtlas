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


    MakeMushroom makeMushroom = new MakeMushroom(mushroomList, input);
    makeMushroom.makeMushroom();
    MenuLogic menuLogic = new MenuLogic(input, makeMushroom);

    menuLogic.runMenu();

    input.close();
  }
}