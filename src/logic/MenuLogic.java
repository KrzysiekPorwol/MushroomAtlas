package logic;

import model.Menu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuLogic {



  public static void navigateMenu(Menu choice) {
    if (choice == Menu.SEARCH_MUSHROOM) {
      System.out.println("Kiedys bedziesz mogl poszukac grzyba");
    } else if (choice == Menu.ADD_MUSHROOM.getNumber()) {
      System.out.println("Kiedys bedziesz mogl dodac grzyba!");
    } else if (choice == Menu.REMOVE_MUSHROOM.getNumber()) {
      System.out.println("Kiedys bedziesz mogl usunac grzyba!");
    } else if (choice == Menu.EXIT.getNumber()) {
      System.out.println("Do zobaczenia!");
    }
  }

  public static Menu showMenu(Scanner input) {

    while (true) {
      printMenu();
      try {
        int choice = input.nextInt();
        input.nextLine();
        Menu option = Menu.fromNumber(choice);
        if (option != null) {
          return option;
        }
        System.out.println("Nie ma takiej opcji w menu, spróbuj jeszcze raz!");
      } catch (InputMismatchException e) {
        input.nextLine();
        System.out.println("\n Wprowadziłes niepoprawne dane, sprobuj jeszcze raz! \n");
      }
    }

  }

  public static void printMenu() {
    for (Menu m : Menu.values()) {
      System.out.println(m.getDescription());
    }
  }


}
