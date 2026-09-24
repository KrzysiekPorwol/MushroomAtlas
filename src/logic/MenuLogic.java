package logic;

import model.Menu;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

public class MenuLogic {

  private final Scanner scanner;
  private final MushroomCreator mushroomCreator;
  private final MushroomSearcher mushroomSearcher;

  public MenuLogic(Scanner scanner, MushroomCreator mushroomCreator, MushroomSearcher mushroomSearcher) {
    this.scanner = scanner;
    this.mushroomCreator = mushroomCreator;
    this.mushroomSearcher = mushroomSearcher;
  }

  private void navigateMenu(Menu choice) {


    switch (choice) {
      case SEARCH_MUSHROOM -> mushroomSearcher.printOneMushroom();
      case SHOW_ALL_MUSHROOMS -> mushroomSearcher.printAllMushrooms();
      case FILTER_MUSHROOMS -> System.out.println("Kiedys bedziesz mogl filtrowac grzyby");
      case ADD_MUSHROOM -> mushroomCreator.makeMushroom();
      case EXIT -> System.out.println("Do zobaczenia!");
    }
  }

  private Menu showMenu() {
    String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
    System.out.println(dateTime);
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
