package io.github.krzysiekporwol.mushroomatlas.model;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class MushroomList {

  private final Set<Mushroom> mushrooms;

  public MushroomList(Set<Mushroom> mushrooms) {
    this.mushrooms = new TreeSet<>(mushrooms);
  }

  public void addMushroom(Mushroom mushroom) {
    mushrooms.add(mushroom);
  }

  public boolean removeMushroom(String name) {
    for (Mushroom m : mushrooms) {
      if (name.equals(m.getName())) {
        mushrooms.remove(m);
        return true;
      }
    }
    return false;
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
