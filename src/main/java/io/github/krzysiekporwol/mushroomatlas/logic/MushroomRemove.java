package io.github.krzysiekporwol.mushroomatlas.logic;

import io.github.krzysiekporwol.mushroomatlas.model.Mushroom;
import io.github.krzysiekporwol.mushroomatlas.repository.MushroomRepository;

import java.util.Scanner;

public class MushroomRemove {

  private final MushroomRepository mushroomRepository;
  private final Scanner scanner;

  public MushroomRemove(MushroomRepository mushroomRepository, Scanner scanner) {
    this.mushroomRepository = mushroomRepository;
    this.scanner = scanner;
  }

  public void removeMushroom() {

    String name = readUserText();


    if (mushroomRepository.remove(name)) {
      mushroomRepository.remove(name);
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
      userText = scanner.nextLine().trim().toLowerCase();
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
