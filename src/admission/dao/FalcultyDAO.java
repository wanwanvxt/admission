package admission.dao;

import admission.model.Falculty;
import admission.util.LogException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FalcultyDAO {

  public List<Falculty> getAllFalculties() {
    List<Falculty> falculties = new ArrayList<>();
    String sql = "SELECT * FROM falculties";

    try (Connection conn = DBConnection.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
      while (rs.next()) {
        Falculty falculty = new Falculty(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("description")
        );
        falculties.add(falculty);
      }
    } catch (SQLException e) {
      LogException.log(this.getClass().getName(), e);
    }

    return falculties;
  }

  public boolean addFalculty(Falculty falculty) {
    String sql = "INSERT INTO falculties (name, description) VALUES (?,?)";

    try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.setString(1, falculty.getName());
      stmt.setString(2, falculty.getDesc());

      return stmt.executeUpdate() > 0;
    } catch (SQLException e) {
      LogException.log(this.getClass().getName(), e);
    }

    return false;
  }

  public boolean updateFalculty(Falculty falculty) {
    String sql = "UPDATE falculties SET name=?, description=? WHERE id=?";

    try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.setString(1, falculty.getName());
      stmt.setString(2, falculty.getDesc());
      stmt.setInt(3, falculty.getId());

      return stmt.executeUpdate() > 0;
    } catch (SQLException e) {
      LogException.log(this.getClass().getName(), e);
    }

    return false;
  }

  public boolean deleteFalculty(int id) {
    String sql = "DELETE FROM falculties WHERE id=?";

    try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.setInt(1, id);

      return stmt.executeUpdate() > 0;
    } catch (SQLException e) {
      LogException.log(this.getClass().getName(), e);
    }

    return false;
  }
}
