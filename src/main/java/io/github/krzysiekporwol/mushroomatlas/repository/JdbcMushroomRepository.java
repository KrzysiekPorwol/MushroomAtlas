package io.github.krzysiekporwol.mushroomatlas.repository;

import io.github.krzysiekporwol.mushroomatlas.database.DatabaseConnection;
import io.github.krzysiekporwol.mushroomatlas.model.Edibility;
import io.github.krzysiekporwol.mushroomatlas.model.Hymenophore;
import io.github.krzysiekporwol.mushroomatlas.model.Mushroom;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

public class JdbcMushroomRepository implements MushroomRepository {
  @Override
  public void add(Mushroom mushroom) {

  }

  @Override
  public boolean remove(String name) {
    return false;
  }

  @Override
  public Set<Mushroom> getAll() {
    Set<Mushroom> mushrooms = new TreeSet<>();
    try (
          Connection connection = DatabaseConnection.getConnection();
          Statement statement = connection.createStatement();
          ResultSet resultSet = statement.executeQuery("SELECT * FROM mushroom");
    ) {
      while (resultSet.next()) {
        String name = resultSet.getString("name");
        String description = resultSet.getString("description");

        int edibilityNumber = resultSet.getInt("edibility_id");
        Optional<Edibility> edibilityOptional = Edibility.fromNumber(edibilityNumber);
        Edibility edibility = edibilityOptional.orElseThrow(
              () -> new IllegalStateException("Nieznana wartość edibility w bazie danych!" + edibilityNumber));

        int hymenophoreNumber = resultSet.getInt("hymenophore_id");
        Optional<Hymenophore> hymenophoreOptional = Hymenophore.fromNumber(hymenophoreNumber);
        Hymenophore hymenophore = hymenophoreOptional.orElseThrow(
              () -> new IllegalStateException("Nieznana wartość hymenophore w bazie danych!" + hymenophoreNumber));

        mushrooms.add(new Mushroom(name, description, edibility, hymenophore));
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return mushrooms;
  }

  @Override
  public List<Mushroom> findByHymenophore(Hymenophore hymenophore) {
    return List.of();
  }

  @Override
  public List<Mushroom> findByEdibility(Edibility edibility) {
    return List.of();
  }

  @Override
  public Optional<Mushroom> findByName(String name) {
    return Optional.empty();
  }
}
