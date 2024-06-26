package admission.dao;

import java.sql.*;

public class DBConnection {

  private static final String URL = "jdbc:mysql://localhost:3306/db_admission";
  private static final String USER = "root";
  private static final String PASSWORD = "";

  public static Connection getConnection() throws SQLException {
    return DriverManager.getConnection(URL, USER, PASSWORD);
  }
}
