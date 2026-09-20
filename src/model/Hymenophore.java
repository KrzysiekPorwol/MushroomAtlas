package model;
// hymenofor
public enum Hymenophore {
  POROID(1, "hymenophor rurkowy"),
  GILLED(2, "hymenophor blaszkowy"),
  TOOTHED(3, "hymenophor kolczasty"),
  GASTEROID(4, "brak hymenophoru");

  private final int number;
  private final String description;

  Hymenophore(int number, String hymenophore) {
    this.number = number;
    this.description = hymenophore;
  }

  public String getDescription() {
    return description;
  }

  public int getNumber() {
    return number;
  }
}
