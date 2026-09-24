package model;

import java.util.List;
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

  public List<Mushroom> findByHymenophore(Hymenophore hymenophore) {
    return getAllMushrooms().stream()
          .filter(mushroom -> mushroom.getHymenophore() == hymenophore)
          .collect(Collectors.toList());
  }

  public List<Mushroom> findByEdibility(Edibility edibility) {
    return getAllMushrooms().stream()
          .filter(mushroom -> mushroom.getEdibility() == edibility)
          .collect(Collectors.toList());
  }

  public Optional<Mushroom> findOneMushroom(String name) {
    return mushrooms.stream().filter(mushroom -> mushroom.getName().equals(name)).findFirst();
  }


}
