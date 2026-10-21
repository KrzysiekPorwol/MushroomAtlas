package io.github.krzysiekporwol.mushroomatlas.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

  private static final String URL = "jdbc:postgresql://localhost:5432/mushroom_atlas";
  private static final String USER = "krzysztofporwol";
  private static final String PASSWORD = "";

  public static Connection getConnection() throws SQLException {
    return DriverManager.getConnection(URL, USER, PASSWORD);
  }

}
