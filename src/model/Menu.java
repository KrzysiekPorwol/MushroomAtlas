package model;

public enum Menu {
  SEARCH_MUSHROOM(1, "Poszukaj konkretnego grzyba - wpisz 1"),
  ADD_MUSHROOM(2, "Dodaj grzyba do kolekcji zdobytych grzybów - wpisz 2"),
  REMOVE_MUSHROOM(3, "Usuń grzyba z kolekcji zdobytych grzybów - wpisz 3"),
  EXIT(0, "Wyjdz z aplikacji - wpisz 0");

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

  public static Menu fromNumber(int number) {
    for (Menu m : values()) {
      if (number == m.getNumber()) {
        return m;
      }
    }
    return null;
  }

//  public static Menu printMenu() {
//    for (Menu m : values()) {
//     System.out.println(m.description);
//    }
//    return
//  }
}
