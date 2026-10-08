package model;

import exception.InvalidMushroomDataException;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Mushroom implements Comparable<Mushroom>, Serializable {

  public static final int MIN_LENGTH = 3;
  private final String name;
  private final String description;
  private final Edibility edibility;
  private final Hymenophore hymenophore;

  @Serial
  private static final long serialVersionUID = 3812017177088226528L;

  public Mushroom(String name, String description, Edibility edibility, Hymenophore hymenophore) {

    String trimmedName = Objects.requireNonNull(name, "Nazwa nie może być nullem").trim().toLowerCase();
    String trimmedDescription = Objects.requireNonNull(description, "Opis nie może być nullem").trim().toLowerCase();
    Edibility notNullEdibility = Objects.requireNonNull(edibility, "Jadalność nie może być nullem");
    Hymenophore notNullHymenophore = Objects.requireNonNull(hymenophore, "Hymenophore nie może być nullem");

    if (trimmedName.length() < MIN_LENGTH) {
      throw new InvalidMushroomDataException("Podana nazwa grzyba jest zbyt krótka");
    }
    if (trimmedDescription.length() < MIN_LENGTH) {
      throw new InvalidMushroomDataException("Podany opis grzyba jest zbyt krótki");
    }

    this.edibility = notNullEdibility;
    this.hymenophore = notNullHymenophore;
    this.name = trimmedName;
    this.description = trimmedDescription;
  }

  public String getName() {
    return name;
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
