package logic;

import model.Menu;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

public class MenuLogic {
abstract

  static void navigateMenu(Menu choice) {

    switch (choice) {
      case SEARCH_MUSHROOM -> System.out.println("Kiedys bedziesz mogl poszukac grzyba");
      case SHOW_ALL_MUSHROOMS -> System.out.println("Kiedys pokaze ci all grzyby!");
      case FILTER_MUSHROOMS -> System.out.println("Kiedys bedziesz mogl filtrowac grzyby");
      case EXIT -> System.out.println("Do zobaczenia!");
    }
  }

  static Menu showMenu(Scanner input) {

    while (true) {
      printMenu();
      try {
        int choice = input.nextInt();
        input.nextLine();
        Optional<Menu> optionalMenu = Menu.fromNumber(choice);
        if (optionalMenu.isPresent()) {
          return optionalMenu.orElseThrow();
        }
        System.out.println("\n Nie ma takiej opcji w menu, spróbuj jeszcze raz! \n");
      } catch (InputMismatchException e) {
        input.nextLine();
        System.out.println("\n Wprowadziłes niepoprawne dane, sprobuj jeszcze raz! \n");
      }
    }
  }

  static void printMenu() {
    for (Menu m : Menu.values()) {
      System.out.println(m.getDescription() + m.getNumber());
    }
  }

  public static void runMenu(Scanner input) {

    Menu choice;
    do {
      choice = MenuLogic.showMenu(input);
      MenuLogic.navigateMenu(choice);
    } while (choice != Menu.EXIT);
  }

}
