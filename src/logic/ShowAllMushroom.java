package logic;

import model.Mushroom;
import model.MushroomList;

import java.util.Set;

public class ShowAllMushroom {


  public static void showAllMushrooms(MushroomList mushroomList) {
    Set<Mushroom> allMushrooms = mushroomList.getAllMushrooms();
    System.out.println("Nazwa | Opis grzyba | rodzaj hymenophoru | jadalność");
    System.out.println("");
    for (Mushroom m : allMushrooms) {
      System.out.println(m.toString());
    }
    System.out.println("");
    System.out.println("");
    System.out.println("");
  }
}
