package model;

public class Mushroom {
  private final String name;
  private final String description;
  private final Edibility edibility;
  private final Hymenophore hymenophore;

  public Mushroom(String name, String description, Edibility edibility, Hymenophore hymenophore) {
    this.name = name;
    this.description = description;
    this.edibility = edibility;
    this.hymenophore = hymenophore;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public Edibility getEdibility() {
    return edibility;
  }

  public Hymenophore getHymenophore() {
    return hymenophore;
  }
}
