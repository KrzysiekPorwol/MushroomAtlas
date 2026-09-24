package logic;

import model.Edibility;
import model.Hymenophore;
import model.Mushroom;
import model.MushroomList;

import java.util.*;

public class MushroomSearcher {

  private final Scanner scanner;
  private final MushroomList mushroomList;

  public MushroomSearcher(Scanner scanner, MushroomList mushroomList) {
    this.scanner = scanner;
    this.mushroomList = mushroomList;
  }

  public void printOneMushroom() {
    boolean nameIsCorrect = false;
    do {
      System.out.println("Podaj nazwę grzyba którego szukasz: ");
      String mushroomName = scanner.nextLine().trim();
      if (mushroomName.length() < 3) {
        System.out.println("\n\nNazwa musi mieć conajmniej 3 znaki\n\n");
      } else {
        mushroomList.findOneMushroom(mushroomName).ifPresentOrElse(
              mushroom -> System.out.println("\n\n" + mushroom + "\n\n"),
              () -> System.out.println("\n\nNie znaleziono grzyba\n\n"));
        nameIsCorrect = true;
      }
    } while (!nameIsCorrect);
  }

  public void printAllMushrooms() {
    Set<Mushroom> allMushrooms = mushroomList.getAllMushrooms();
    System.out.println("Nazwa | Opis grzyba | rodzaj hymenophoru | jadalność\n");
    for (Mushroom m : allMushrooms) {
      System.out.println(m.toString() + "\n");
    }
  }

  public void filtrAllMushrooms() {
    System.out.println("Jak chcesz filtrować grzyby?\nWybierz 1 - po jadalności, wybierz 2 - po hymenophorze");
    try {
      int userChosen = scanner.nextInt();
      scanner.nextLine();
      if (userChosen == 1) {
        System.out.println("Jaki typ grzybów wybierasz?");
        for (Edibility e : Edibility.values()) {
          System.out.println("Wybierz " + e.getNumber() + " - " + e.getDescription());
        }
        userChosen = scanner.nextInt();
        scanner.nextLine();
        switch (userChosen) {
          case 1 -> {
            List<Mushroom> mushroomsByEdibility = mushroomList.findByEdibility(Edibility.EDIBLE);
            System.out.println("Grzyby jadalne:");
            if (mushroomsByEdibility.isEmpty()) {
              System.out.println("Brak tego typu grzyba w atlasie!");
            } else {
              for (Mushroom m : mushroomsByEdibility) {
                System.out.println(m + "\n");
              }
            }
          }
          case 2 -> {
            List<Mushroom> mushroomsByEdibility = mushroomList.findByEdibility(Edibility.INEDIBLE);
            System.out.println("Grzyby niejadalne:");
            if (mushroomsByEdibility.isEmpty()) {
              System.out.println("Brak tego typu grzyba w atlasie!");
            } else {
              for (Mushroom m : mushroomsByEdibility) {
                System.out.println(m + "\n");
              }
            }
          }
          case 3 -> {
            List<Mushroom> mushroomsByEdibility = mushroomList.findByEdibility(Edibility.POISONUS);
            System.out.println("Grzyby trujące:");
            if (mushroomsByEdibility.isEmpty()) {
              System.out.println("Brak tego typu grzyba w atlasie!");
            } else {
              for (Mushroom m : mushroomsByEdibility) {
                System.out.println(m + "\n");
              }
            }
          }
          default -> System.out.println("Wprowadziłeś niepoprawną cyfrę!");
        }
      } else if (userChosen == 2) {
        System.out.println("Jaki typ grzybów wybierasz?\n");
        for (Hymenophore h : Hymenophore.values()) {
          System.out.println("Wybierz " + h.getNumber() + " - " + h.getDescription());
        }
        userChosen = scanner.nextInt();
        scanner.nextLine();
        switch (userChosen) {
          case 1 -> {
            List<Mushroom> mushroomsByHymenophore = mushroomList.findByHymenophore(Hymenophore.POROID);
            System.out.println("Hymenofor rurkowy: ");
            if (mushroomsByHymenophore.isEmpty()) {
              System.out.println("Brak tego typu grzyba w atlasie!");
            } else {
              for (Mushroom m : mushroomsByHymenophore) {
                System.out.println(m + "\n");
              }
            }
          }
          case 2 -> {
            List<Mushroom> mushroomsByHymenophore = mushroomList.findByHymenophore(Hymenophore.GILLED);
            System.out.println("Hymenofor blaszkowy: ");
            if (mushroomsByHymenophore.isEmpty()) {
              System.out.println("Brak tego typu grzyba w atlasie!");
            } else {
              for (Mushroom m : mushroomsByHymenophore) {
                System.out.println(m + "\n");
              }
            }
          }
          case 3 -> {
            List<Mushroom> mushroomsByHymenophore = mushroomList.findByHymenophore(Hymenophore.TOOTHED);
            System.out.println("Hymenofor kolczasty: ");
            if (mushroomsByHymenophore.isEmpty()) {
              System.out.println("Brak tego typu grzyba w atlasie!");
            } else {
              for (Mushroom m : mushroomsByHymenophore) {
                System.out.println(m + "\n");
              }
            }
          }
          case 4 -> {
            List<Mushroom> mushroomsByHymenophore = mushroomList.findByHymenophore(Hymenophore.GASTEROID);
            System.out.println("Bez hymenoforu: ");
            if (mushroomsByHymenophore.isEmpty()) {
              System.out.println("Brak tego typu grzyba w atlasie!");
            } else {
              for (Mushroom m : mushroomsByHymenophore) {
                System.out.println(m + "\n");
              }
            }
          }
          default -> System.out.println("Wprowadziłeś niepoprawną cyfrę!");
        }
      } else {
        System.out.println("Wprowadziłeś niepoprawną cyfrę!");
      }
    } catch (InputMismatchException e) {
      System.out.println("Wprowadziłeś niepoprawne dane!");
      scanner.nextLine();
    }
  }
}

