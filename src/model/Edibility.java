package model;

public enum Edibility {
  EDIBLE("Grzyb jadalny"),
  INEDIBLE("Grzyb niejadalny"),
  POISONUS("Grzyb trujący");

  private final String description;

  Edibility(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }


}
