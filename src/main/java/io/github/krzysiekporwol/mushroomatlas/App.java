package io.github.krzysiekporwol.mushroomatlas;

import io.github.krzysiekporwol.mushroomatlas.exception.DatabaseException;
import io.github.krzysiekporwol.mushroomatlas.logic.MenuLogic;
import io.github.krzysiekporwol.mushroomatlas.logic.MushroomCreator;
import io.github.krzysiekporwol.mushroomatlas.logic.MushroomRemove;
import io.github.krzysiekporwol.mushroomatlas.logic.MushroomSearcher;
import io.github.krzysiekporwol.mushroomatlas.repository.JdbcMushroomRepository;

import java.util.Scanner;

public class App {

  public static void main(String[] args) {

    System.out.println("Witaj w aplikacji atlas grzybów!\n");

    JdbcMushroomRepository mushroomList = new JdbcMushroomRepository();

    Scanner scanner = new Scanner(System.in);

    MushroomCreator mushroomCreator = new MushroomCreator(mushroomList, scanner);
    MushroomRemove mushroomRemove = new MushroomRemove(mushroomList, scanner);
    MushroomSearcher mushroomSearcher = new MushroomSearcher(scanner, mushroomList);
    MenuLogic menuLogic = new MenuLogic(scanner, mushroomCreator, mushroomSearcher, mushroomRemove);

    try {
      menuLogic.runMenu();
    } catch (DatabaseException e) {
      System.out.println(e.getMessage() + "\n" + e.getCause().getMessage());
    }

    scanner.close();
  }
}