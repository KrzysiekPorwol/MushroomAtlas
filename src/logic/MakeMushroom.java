package logic;

import exception.IncorrectNameException;
import model.*;

import java.util.*;

public class MakeMushroom {

  private final MushroomList mushroomList;
  private final Scanner scanner;

  public MakeMushroom(MushroomList mushroomList, Scanner scanner) {
    this.mushroomList = mushroomList;
    this.scanner = scanner;
  }


  public void makeMushroom() {
    boolean condition = true;
    do {
      String name = getName();
      String description = getDescription();
      Edibility edibility = getEdibility();
      Hymenophore hymenophore = getHymenophore();
      try {
        Mushroom mushroom = new Mushroom(name, description, edibility, hymenophore);
        mushroomList.addMushroom(mushroom);
        condition = false;
        System.out.println("Udało się dodać grzyba " + name + " do atlasu!");
      } catch (IncorrectNameException | NullPointerException e) {
        System.out.println(e.getMessage());
      }

    } while (condition);
  }

  private String getName() {
    System.out.println("Podaj nazwę grzyba: ");
    String name = scanner.nextLine();
    return name;
  }

  private String getDescription() {
    System.out.println("Podaj opis grzyba: ");
    String description = scanner.nextLine();
    return description;
  }

  private Edibility getEdibility() {
    boolean condition = true;
    Edibility edibility = Edibility.EDIBLE;
    do {
      System.out.println("jaki to rodzaj grzyba: wpisz 1, jeśli jadalny, 2 jeśli niejadalny, 3 jeśli trujący");
      try {
        int choice = scanner.nextInt();
        for (Edibility e : Edibility.values()) {
          if (choice == e.getNumber()) {
            condition = false;
            edibility = e;
          }
        }
        if (choice != Edibility.EDIBLE.getNumber() && choice != 2 && choice != 3) {
          System.out.println("\n Wprowadziłeś niepoprawna liczbę, spróbuj jeszcze raz! \n");
        }
        scanner.nextLine();
      } catch (InputMismatchException e) {
        scanner.nextLine();
        System.out.println("\n Wprowadziłeś niepoprawne dane, spróbuj jeszcze raz! \n");
      }
    } while (condition);
    return edibility;
  }

  private Hymenophore getHymenophore() {
    boolean condition = true;
    Hymenophore hymenophore = Hymenophore.POROID;
    do {
      System.out.println("jaki to rodzaj hymenoforu: wpisz 1, jeśli rurkowy, 2 jeśli blaszkowy, 3 jeśli kolczasty i 4 jeśli bez kapeluszowy");
      try {
        int choice = scanner.nextInt();
        for (Hymenophore h : Hymenophore.values()) {
          if (choice == h.getNumber()) {
            condition = false;
            hymenophore = h;
          }
        }
        if (choice != 1 && choice != 2 && choice != 3 && choice != 4) {
          System.out.println("\n Wprowadziłeś niepoprawna liczbę, spróbuj jeszcze raz! \n");
        }
        scanner.nextLine();
      } catch (InputMismatchException e) {
        scanner.nextLine();
        System.out.println("\n Wprowadziłeś niepoprawne dane, spróbuj jeszcze raz! \n");
      }
    } while (condition);
    return hymenophore;
  }
}
