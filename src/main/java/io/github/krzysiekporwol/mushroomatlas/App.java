package io.github.krzysiekporwol.mushroomatlas;

import io.github.krzysiekporwol.mushroomatlas.exception.DatabaseException;
import io.github.krzysiekporwol.mushroomatlas.logic.MenuLogic;
import io.github.krzysiekporwol.mushroomatlas.logic.MushroomCreator;
import io.github.krzysiekporwol.mushroomatlas.logic.MushroomRemove;
import io.github.krzysiekporwol.mushroomatlas.logic.MushroomSearcher;
import io.github.krzysiekporwol.mushroomatlas.repository.JdbcMushroomRepository;
import io.github.krzysiekporwol.mushroomatlas.repository.MushroomRepository;

import java.util.Scanner;

public class App {

  public static void main(String[] args) {

    System.out.println("Witaj w aplikacji atlas grzybów!\n");

    MushroomRepository mushroomRepository = new JdbcMushroomRepository();

    Scanner scanner = new Scanner(System.in);

    MushroomCreator mushroomCreator = new MushroomCreator(mushroomRepository, scanner);
    MushroomRemove mushroomRemove = new MushroomRemove(mushroomRepository, scanner);
    MushroomSearcher mushroomSearcher = new MushroomSearcher(scanner, mushroomRepository);
    MenuLogic menuLogic = new MenuLogic(scanner, mushroomCreator, mushroomSearcher, mushroomRemove);

    try {
      menuLogic.runMenu();
    } catch (DatabaseException e) {
      System.out.println(e.getMessage() + "\n" + e.getCause().getMessage());
    }

    scanner.close();
  }
}