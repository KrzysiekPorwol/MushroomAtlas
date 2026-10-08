package logic;

import model.Mushroom;
import model.MushroomList;

import java.util.Scanner;

public class MushroomRemove {

  private final MushroomList mushroomList;
  private final Scanner scanner;

  public MushroomRemove(MushroomList mushroomList, Scanner scanner) {
    this.mushroomList = mushroomList;
    this.scanner = scanner;
  }

  public void removeMushroom() {

    String name = readUserText();


    if (mushroomList.removeMushroom(name)) {
      mushroomList.removeMushroom(name);
      System.out.println("Udało się usunąć grzyba " + name + " z atlasu!");
    } else {
      System.out.println("Nie znaleziono grzyba " + name + " w atlasie!");

    }
  }

  private String readUserText() {
    String text = "Podaj nazwę grzyba który chcesz usunąć: ";
    boolean textIsIncorrect = true;
    String userText;
    do {
      System.out.println(text);
      userText = scanner.nextLine().trim();
      if (userText.isBlank()) {
        System.out.println("Wprowadzony tekst nie może być pusty");
        continue;
      } else if (userText.length() < Mushroom.MIN_LENGTH) {
        System.out.println("Wprowadzony tekst nie może być krótszy niż " + Mushroom.MIN_LENGTH + " znaki");
        continue;
      }
      textIsIncorrect = false;
    } while (textIsIncorrect);
    return userText;
  }
}
