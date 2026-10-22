package io.github.krzysiekporwol.mushroomatlas.repository;

import io.github.krzysiekporwol.mushroomatlas.database.DatabaseConnection;
import io.github.krzysiekporwol.mushroomatlas.exception.DatabaseException;
import io.github.krzysiekporwol.mushroomatlas.exception.MushroomAlreadyExistsException;
import io.github.krzysiekporwol.mushroomatlas.model.Edibility;
import io.github.krzysiekporwol.mushroomatlas.model.Hymenophore;
import io.github.krzysiekporwol.mushroomatlas.model.Mushroom;

import java.sql.*;
import java.util.*;

public class JdbcMushroomRepository implements MushroomRepository {

  private static final String UNIQUE_VIOLATION = "23505";

  @Override
  public void add(Mushroom mushroom) {
    try (
        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(
            "INSERT INTO mushroom (name, description, edibility_id, hymenophore_id) " +
                "VALUES (?, ?, ?, ?)"
        )
    ) {
      statement.setString(1, mushroom.getName());
      statement.setString(2, mushroom.getDescription());
      statement.setInt(3, mushroom.getEdibility().getNumber());
      statement.setInt(4, mushroom.getHymenophore().getNumber());

      statement.executeUpdate();
    } catch (SQLException e) {
      if (UNIQUE_VIOLATION.equals(e.getSQLState())) {
        throw new MushroomAlreadyExistsException("Taki grzyb już istnieje w atlasie", e);
      } else {
        throw new DatabaseException("Nie udało się dodać grzyba", e);
      }
    }
  }

  @Override
  public boolean remove(String name) {
    try (
        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(
            "DELETE FROM mushroom " +
                "WHERE name = ?"
        )
    ) {
      statement.setString(1, name);
      return statement.executeUpdate() > 0;
    } catch (SQLException e) {
      throw new DatabaseException("Nie udało się usunąć grzyba", e);
    }
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

        mushrooms.add(mapRow(resultSet));
      }
    } catch (SQLException e) {
      throw new DatabaseException("Nie udało się wczytać grzybów", e);
    }
    return mushrooms;
  }

  @Override
  public List<Mushroom> findByHymenophore(Hymenophore hymenophore) {
    List<Mushroom> mushrooms = new ArrayList<>();
    try (
        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(
            "SELECT * FROM mushroom WHERE hymenophore_id = ?"
        )
    ) {
      statement.setInt(1, hymenophore.getNumber());
      try (
          ResultSet resultSet = statement.executeQuery();
      ) {
        while (resultSet.next()) {
          mushrooms.add(mapRow(resultSet));
        }
      }
      return mushrooms;
    } catch (SQLException e) {
      throw new DatabaseException("Nie udało się przefiltrować grzybów", e);
    }
  }

  @Override
  public List<Mushroom> findByEdibility(Edibility edibility) {
    List<Mushroom> mushrooms = new ArrayList<>();
    try (
        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(
            "SELECT * FROM mushroom WHERE edibility_id = ?"
        )
    ) {
      statement.setInt(1, edibility.getNumber());
      try (
          ResultSet resultSet = statement.executeQuery();
      ) {
        while (resultSet.next()) {
          mushrooms.add(mapRow(resultSet));
        }
      }
      return mushrooms;
    } catch (SQLException e) {
      throw new DatabaseException("Nie udało się przefiltrować grzybów", e);
    }
  }

  @Override
  public Optional<Mushroom> findByName(String name) {
    try (
        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(
            "SELECT * FROM mushroom WHERE name = ?"
        )
    ) {
      statement.setString(1, name);
      try (
          ResultSet resultSet = statement.executeQuery();
      ) {
        if (resultSet.next()) {

          Mushroom mushroom = mapRow(resultSet);

          return Optional.of(mushroom);
        }
      }
    } catch (SQLException e) {
      throw new DatabaseException("Nie udało się znaleźć grzyba", e);
    }
    return Optional.empty();
  }

  private static Mushroom mapRow(ResultSet resultSet) throws SQLException {
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

    return new Mushroom(name, description, edibility, hymenophore);
  }
}


