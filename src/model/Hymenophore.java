package model;
// hymenofor
public enum Hymenophore {
  POROID(1, "rurkowe"),
  GILLED(2, "blaszkowe"),
  TOOTHED(3, "kolczaste"),
  GASTEROID(4, "bezkapeluszowe");

  private final int number;
  private final String hymenophore;

  Hymenophore(int number, String hymenophore) {
    this.number = number;
    this.hymenophore = hymenophore;
  }

  public String getHymenophore() {
    return hymenophore;
  }

  public int getNumber() {
    return number;
  }
}
