package model;
// hymenofor
public enum Hymenophore {
  POROID("rurkowe"),
  GILLED("blaszkowe"),
  TOOTHED("kolczaste"),
  GASTEROID("bezkapeluszowe");

  private final String hymenophore;

  Hymenophore(String hymenophore) {
    this.hymenophore = hymenophore;
  }

  public String getHymenophore() {
    return hymenophore;
  }
}
