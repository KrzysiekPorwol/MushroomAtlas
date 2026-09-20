package model;

import exception.IncorrectNameException;

import java.util.Objects;

public class Mushroom implements Comparable<Mushroom> {
  private final String name;
  private final String description;
  private final Edibility edibility;
  private final Hymenophore hymenophore;

  public Mushroom(String name, String description, Edibility edibility, Hymenophore hymenophore) throws IncorrectNameException {
    if (name == null) {
      throw new NullPointerException("Nazwa nie może być nullem");
    } else if (edibility == null) {
      throw new NullPointerException("Jadalność nie może być nullem");
    } else if (hymenophore == null) {
      throw new NullPointerException("Hymenophore nie może być nullem");
    }
    if (name.isBlank()) {
      throw new IncorrectNameException("Podana nazwa grzyba jest niepoprawna");
    }
    this.name = name.trim().toLowerCase();
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

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    Mushroom mushroom = (Mushroom) o;
    return Objects.equals(name, mushroom.name);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(name);
  }

  @Override
  public int compareTo(Mushroom other) {
    return this.name.compareTo(other.name);
  }

  @Override
  public String toString() {
    return name + " | " + description  + " | " + hymenophore.getDescription()  + " | " + edibility.getDescription();
  }
}
