package io.github.krzysiekporwol.mushroomatlas;

import io.github.krzysiekporwol.mushroomatlas.exception.InvalidFileReadException;
import io.github.krzysiekporwol.mushroomatlas.exception.InvalidFileSaveException;
import io.github.krzysiekporwol.mushroomatlas.logic.MenuLogic;
import io.github.krzysiekporwol.mushroomatlas.logic.MushroomCreator;
import io.github.krzysiekporwol.mushroomatlas.logic.MushroomRemove;
import io.github.krzysiekporwol.mushroomatlas.logic.MushroomSearcher;
import io.github.krzysiekporwol.mushroomatlas.logic.file.FileCreator;
import io.github.krzysiekporwol.mushroomatlas.model.MushroomList;

import java.util.Scanner;

public class App {

  static void main() {

    System.out.println("Witaj w aplikacji atlas grzybów!");
    System.out.println("");

    FileCreator fileCreator = new FileCreator();

    try {
      MushroomList mushroomList = new MushroomList(fileCreator.readMushroom());

      Scanner scanner = new Scanner(System.in);

      MushroomCreator mushroomCreator = new MushroomCreator(mushroomList, scanner);
      MushroomRemove mushroomRemove = new MushroomRemove(mushroomList, scanner);
      MushroomSearcher mushroomSearcher = new MushroomSearcher(scanner, mushroomList);
      MenuLogic menuLogic = new MenuLogic(scanner, mushroomCreator, mushroomSearcher, mushroomRemove);

      menuLogic.runMenu();

      fileCreator.saveMushroom(mushroomList.getAllMushrooms());

      scanner.close();
    } catch (InvalidFileReadException e) {
      System.out.println(
            "Nie udało się połączyć z plikiem - sprawdź plik mushrooms.txt"
      );
    } catch (InvalidFileSaveException e) {
      System.out.println(
            "Nie udało się połączyć z plikiem - sprawdź plik mushrooms.txt - program nie zapisze nowych grzybów dodanych do atlasu."
      );
    }
  }
}