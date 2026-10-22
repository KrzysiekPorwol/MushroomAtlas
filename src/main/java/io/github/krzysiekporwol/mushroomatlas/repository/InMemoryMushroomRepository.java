package io.github.krzysiekporwol.mushroomatlas.repository;

import io.github.krzysiekporwol.mushroomatlas.model.Edibility;
import io.github.krzysiekporwol.mushroomatlas.model.Hymenophore;
import io.github.krzysiekporwol.mushroomatlas.model.Mushroom;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class InMemoryMushroomRepository implements MushroomRepository {

  private final Set<Mushroom> mushrooms;


  public InMemoryMushroomRepository(Set<Mushroom> mushrooms) {
    this.mushrooms = new TreeSet<>(mushrooms);
  }

  @Override
  public void add(Mushroom mushroom) {
    mushrooms.add(mushroom);
  }

  @Override
  public boolean remove(String name) {
    for (Mushroom m : mushrooms) {
      if (name.equals(m.getName())) {
        mushrooms.remove(m);
        return true;
      }
    }
    return false;
  }

  @Override
  public Set<Mushroom> getAll() {
    return new TreeSet<>(mushrooms);
  }

  @Override
  public List<Mushroom> findByHymenophore(Hymenophore hymenophore) {
    return getAll().stream()
          .filter(mushroom -> mushroom.getHymenophore() == hymenophore)
          .collect(Collectors.toList());
  }

  @Override
  public List<Mushroom> findByEdibility(Edibility edibility) {
    return getAll().stream()
          .filter(mushroom -> mushroom.getEdibility() == edibility)
          .collect(Collectors.toList());
  }

  @Override
  public Optional<Mushroom> findByName(String name) {
    return mushrooms.stream().filter(mushroom -> mushroom.getName().equals(name)).findFirst();
  }
}
