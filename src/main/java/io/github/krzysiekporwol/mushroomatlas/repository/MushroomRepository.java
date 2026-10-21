package io.github.krzysiekporwol.mushroomatlas.repository;

import io.github.krzysiekporwol.mushroomatlas.model.Edibility;
import io.github.krzysiekporwol.mushroomatlas.model.Hymenophore;
import io.github.krzysiekporwol.mushroomatlas.model.Mushroom;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface MushroomRepository {

  void add(Mushroom mushroom);

  boolean remove(String name);

  Set<Mushroom> getAll();

  List<Mushroom> findByHymenophore(Hymenophore hymenophore);

  List<Mushroom> findByEdibility(Edibility edibility);

  Optional<Mushroom> findByName(String name);
}
