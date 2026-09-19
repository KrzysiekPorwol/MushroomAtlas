package logic;

import model.Menu;
import model.MushroomList;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

public class MenuLogic {

  private MushroomList mushroomList;
  private Scanner scanner;

  public MenuLogic(MushroomList mushroomList, Scanner scanner) {
    this.mushroomList = mushroomList;
    this.scanner = scanner;
  }

  private void navigateMenu(Menu choice) {


    switch (choice) {
      case SEARCH_MUSHROOM -> System.out.println("Kiedys bedziesz mogl poszukac grzyba");
      case SHOW_ALL_MUSHROOMS -> System.out.println("Kiedys pokaze ci all grzyby!");
      case FILTER_MUSHROOMS -> System.out.println("Kiedys bedziesz mogl filtrowac grzyby");
      case ADD_MUSHROOM -> MakeMushroom.makeMushroom(mushroomList, scanner);
      case EXIT -> System.out.println("Do zobaczenia!");
    }
  }

  private Menu showMenu(Scanner input) {

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

  private void printMenu() {
    for (Menu m : Menu.values()) {
      System.out.println(m.getDescription() + m.getNumber());
    }
  }

  public void runMenu(Scanner input) {
    Menu choice;
    do {
      choice = showMenu(input);
      navigateMenu(choice);
    } while (choice != Menu.EXIT);
  }

}
