package io.github.krzysiekporwol.mushroomatlas.logic;

import io.github.krzysiekporwol.mushroomatlas.exception.MushroomAlreadyExistsException;
import io.github.krzysiekporwol.mushroomatlas.model.Edibility;
import io.github.krzysiekporwol.mushroomatlas.model.Hymenophore;
import io.github.krzysiekporwol.mushroomatlas.model.Mushroom;
import io.github.krzysiekporwol.mushroomatlas.repository.MushroomRepository;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

public class MushroomCreator {

  private final MushroomRepository mushroomRepository;
  private final Scanner scanner;

  public MushroomCreator(MushroomRepository mushroomRepository, Scanner scanner) {
    this.mushroomRepository = mushroomRepository;
    this.scanner = scanner;
  }


  public void makeMushroom() {

    String name = readUserText("Podaj nazwę grzyba: ");

    String description = readUserText("Podaj opis grzyba: ");

    Edibility edibility = getEdibility();

    Hymenophore hymenophore = getHymenophore();

    Mushroom mushroom = new Mushroom(name, description, edibility, hymenophore);
    try {
      mushroomRepository.add(mushroom);
      System.out.println("Udało się dodać grzyba " + name + " do atlasu!");
    } catch (MushroomAlreadyExistsException e) {
      System.out.println(e.getMessage());
    }

  }

  private String readUserText(String text) {
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

  private Edibility getEdibility() {

    Optional<Edibility> edibility;

    do {
      System.out.println("jaki to rodzaj grzyba: wpisz 1, jeśli jadalny, 2 jeśli niejadalny, 3 jeśli trujący");
      try {
        int choice = scanner.nextInt();
        scanner.nextLine();

        edibility = Edibility.fromNumber(choice);

        if (edibility.isEmpty()) {
          System.out.println("\n Wprowadziłeś niepoprawna liczbę, spróbuj jeszcze raz! \n");
        }

      } catch (InputMismatchException e) {
        scanner.nextLine();
        System.out.println("\n Wprowadziłeś niepoprawne dane, spróbuj jeszcze raz! \n");
        edibility = Optional.empty();
      }
    } while (edibility.isEmpty());
    return edibility.get();
  }

  private Hymenophore getHymenophore() {

    Optional<Hymenophore> hymenophore;

    do {
      System.out.println("jaki to rodzaj hymenoforu: wpisz 1, jeśli rurkowy, 2 jeśli blaszkowy, 3 jeśli kolczasty i 4 jeśli bez kapeluszowy");
      try {
        int choice = scanner.nextInt();
        scanner.nextLine();
        hymenophore = Hymenophore.fromNumber(choice);

        if (hymenophore.isEmpty()) {
          System.out.println("\n Wprowadziłeś niepoprawna liczbę, spróbuj jeszcze raz! \n");
        }

      } catch (InputMismatchException e) {
        scanner.nextLine();
        System.out.println("\n Wprowadziłeś niepoprawne dane, spróbuj jeszcze raz! \n");
        hymenophore = Optional.empty();
      }
    } while (hymenophore.isEmpty());
    return hymenophore.get();
  }
}
