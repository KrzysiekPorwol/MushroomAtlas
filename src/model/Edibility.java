package model;

public enum Edibility {
  EDIBLE(1, "Grzyb jadalny"),
  INEDIBLE(2, "Grzyb niejadalny"),
  POISONUS(3, "Grzyb trujący");

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
