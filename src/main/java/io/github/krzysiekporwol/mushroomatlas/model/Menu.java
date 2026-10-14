package io.github.krzysiekporwol.mushroomatlas.model;

import java.util.Optional;

public enum Menu {
  SEARCH_MUSHROOM(1, "Poszukaj konkretnego grzyba - wpisz "),
  SHOW_ALL_MUSHROOMS(2, "Pokaż wszystkie grzyby alfabetycznie - wpisz "),
  FILTER_MUSHROOMS(3, "Wyfiltruj konkretne grzyby - wpisz "),
  ADD_MUSHROOM(4, "Dodaj nowego grzyba do atlasu - wpisz "),
  REMOVE_MUSHROOM(5, "Usun grzyba z atlasu - wpisz "),
  EXIT(0, "Wyjdz z aplikacji - wpisz ");

  private final int number;
  private final String description;

  Menu(int number, String description) {
    this.description = description;
    this.number = number;
  }

  public String getDescription() {
    return description;
  }

  public int getNumber() {
    return number;
  }

  public static Optional<Menu> fromNumber(int number) {
    for (Menu m : values()) {
      if (number == m.getNumber()) {
        return Optional.of(m);
      }
    }
    return Optional.empty();
  }

}
