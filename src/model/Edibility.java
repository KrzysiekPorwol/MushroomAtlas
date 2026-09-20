package model;

public enum Edibility {
  EDIBLE(1, "jadalny"),
  INEDIBLE(2, "niejadalny"),
  POISONUS(3, "trujący");

  private final int number;
  private final String description;

  Edibility(int number, String description) {
    this.number = number;
    this.description = description;
  }

  public String getDescription() {
    return description;
  }

  public int getNumber() {
    return number;
  }
}
