package logic;

import model.Mushroom;
import model.MushroomList;

import java.util.Scanner;
import java.util.Set;

public class SearchMushroom {

  private final Scanner scanner;
  private final MushroomList mushroomList;

  public SearchMushroom(Scanner scanner, MushroomList mushroomList) {
    this.scanner = scanner;
    this.mushroomList = mushroomList;
  }


  public void showOneMushroom() {
    boolean nameIsCorrect = false;
    do {
      System.out.println("Podaj nazwę grzyba którego szukasz: ");
      String mushroomName = scanner.nextLine().trim();
      if (mushroomName.length() < 3) {
        System.out.println("\n\nNazwa musi mieć conajmniej 3 znaki\n\n");
      } else {
        mushroomList.getOneMushroom(mushroomName).ifPresentOrElse(
              mushroom -> System.out.println("\n\n" + mushroom + "\n\n"),
              () -> System.out.println("\n\nNie znaleziono grzyba\n\n"));
        nameIsCorrect = true;
      }
    } while (!nameIsCorrect);

  }


  public void showAllMushrooms() {
    Set<Mushroom> allMushrooms = mushroomList.getAllMushrooms();
    System.out.println("Nazwa | Opis grzyba | rodzaj hymenophoru | jadalność\n");
    for (Mushroom m : allMushrooms) {
      System.out.println(m.toString() + "\n");
    }
  }
}


//  public void showOneMushroom() {
//    Map<String, Mushroom> mapMushroom = new HashMap<>();
//    for (Mushroom m : mushroomList.getAllMushrooms()) {
//      mapMushroom.put(m.getName(), m);
//    }
//    System.out.println("Podaj nazwę grzyba którego szukasz: ");
//    String mushroomName = scanner.nextLine();
//    System.out.println(mapMushroom.get(mushroomName));
//  }

