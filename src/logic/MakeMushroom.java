package logic;

import exception.IncorrectNameException;
import model.Edibility;
import model.Hymenophore;
import model.Mushroom;
import model.MushroomList;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class MakeMushroom {

  public static Mushroom makeMushroom(MushroomList mushroomList, Scanner input) {

    do {
      System.out.println("Podaj nazwę grzyba: ");
      String name = input.nextLine();
      System.out.println("Podaj opis grzyba: ");
      String description = input.nextLine();
      System.out.println("jaki to rodzaj grzyba: ");
      Edibility edibility = Edibility.EDIBLE;
      System.out.println("jaki to rodzaj grzyba: ");
      Hymenophore hymenophore = Hymenophore.POROID;
      try {
        return new Mushroom(name, description, edibility, hymenophore);
      } catch (IncorrectNameException | NullPointerException e) {
        System.out.println(e.getMessage());
      }
    } while (true);
  }


//  public Set<Mushroom> addMushroomToList(TreeSet<Mushroom> mushroomTreeSet) {
//
//    try {
//      new Mushroom(
//            "borowik"
//            , "powszechnie nazywany prawdziwkiem, to jeden z najbardziej cenionych " +
//            "i rozpoznawalnych grzybów jadalnych w polskich lasach"
//            , Edibility.EDIBLE
//            , Hymenophore.POROID);
//    } catch (IncorrectNameException | NullPointerException e) {
//      System.out.println(e.getMessage());
//    }
//  }
}
