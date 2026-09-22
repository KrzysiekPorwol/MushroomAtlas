package logic;

import model.Menu;
import model.MushroomList;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

public class MenuLogic {

  private final Scanner scanner;
  private final MakeMushroom makeMushroom;
  private final MushroomList mushroomList;

  public MenuLogic(Scanner scanner, MakeMushroom makeMushroom, MushroomList mushroomList) {
    this.scanner = scanner;
    this.makeMushroom = makeMushroom;
    this.mushroomList = mushroomList;
  }

  private void navigateMenu(Menu choice) {


    switch (choice) {
      case SEARCH_MUSHROOM -> System.out.println("Kiedys bedziesz mogl poszukac grzyba");
      case SHOW_ALL_MUSHROOMS -> ShowAllMushroom.showAllMushrooms(mushroomList);
      case FILTER_MUSHROOMS -> System.out.println("Kiedys bedziesz mogl filtrowac grzyby");
      case ADD_MUSHROOM -> makeMushroom.makeMushroom();
      case EXIT -> System.out.println("Do zobaczenia!");
    }
  }

  private Menu showMenu() {

    while (true) {
      printMenu();
      try {
        int choice = scanner.nextInt();
        scanner.nextLine();
        Optional<Menu> optionalMenu = Menu.fromNumber(choice);
        if (optionalMenu.isPresent()) {
          return optionalMenu.orElseThrow();
        }
        System.out.println("\n Nie ma takiej opcji w menu, spróbuj jeszcze raz! \n");
      } catch (InputMismatchException e) {
        scanner.nextLine();
        System.out.println("\n Wprowadziłes niepoprawne dane, sprobuj jeszcze raz! \n");
      }
    }
  }

  private void printMenu() {
    for (Menu m : Menu.values()) {
      System.out.println(m.getDescription() + m.getNumber());
    }
  }

  public void runMenu() {
    Menu choice;
    do {
      choice = showMenu();
      navigateMenu(choice);
    } while (choice != Menu.EXIT);
  }

}
