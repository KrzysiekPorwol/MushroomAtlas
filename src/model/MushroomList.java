package model;

import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class MushroomList {

  private final Set<Mushroom> mushrooms = new TreeSet<>();

  public void addMushroom(Mushroom mushroom) {
    mushrooms.add(mushroom);
  }

  public Set<Mushroom> getAllMushrooms() {
    return new TreeSet<>(mushrooms);
  }

  public Set<Mushroom> getEdibilityMushrooms(Edibility edibility) {
    return mushrooms.stream()
          .filter(mushroom -> mushroom.getEdibility() == edibility)
          .collect(Collectors.toCollection(() -> new TreeSet<>()));
  }

  public Set<Mushroom> getHymenophoreMushrooms(Hymenophore hymenophore) {
    return mushrooms.stream()
          .filter(mushroom -> mushroom.getHymenophore() == hymenophore)
          .collect(Collectors.toCollection(() -> new TreeSet<>()));
  }

  public Optional<Mushroom> getOneMushroom(String name) {
    return mushrooms.stream().filter(mushroom -> mushroom.getName().equals(name)).findFirst();
  }
}
