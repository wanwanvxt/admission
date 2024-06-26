package admission.dao;

import admission.model.Major;
import admission.util.LogException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MajorDAO {

  public List<Major> getAllMajors() {
    List<Major> majors = new ArrayList<>();
    String sql = "SELECT * FROM majors";

    try (Connection conn = DBConnection.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
      while (rs.next()) {
        Major major = new Major(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("description"),
                rs.getInt("falculty_id"),
                rs.getDouble("base_score"),
                rs.getInt("quota")
        );
        majors.add(major);
      }
    } catch (SQLException e) {
      LogException.log(this.getClass().getName(), e);
    }

    return majors;
  }

  public boolean addMajor(Major major) {
    String sql = "INSERT INTO majors (name, description, falculty_id, quota) VALUES (?,?,?,?)";

    try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.setString(1, major.getName());
      stmt.setString(2, major.getDesc());
      stmt.setInt(3, major.getFalcultyId());
      stmt.setInt(4, major.getQuota());

      return stmt.executeUpdate() > 0;
    } catch (SQLException e) {
      LogException.log(this.getClass().getName(), e);
    }

    return false;
  }

  public boolean updateMajor(Major major) {
    String sql = "UPDATE majors SET name=?, description=?, falculty_id=?, base_score=?, quota=? WHERE id=?";

    try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.setString(1, major.getName());
      stmt.setString(2, major.getDesc());
      stmt.setInt(3, major.getFalcultyId());
      stmt.setDouble(4, major.getBaseScore());
      stmt.setInt(5, major.getQuota());
      stmt.setInt(6, major.getId());

      return stmt.executeUpdate() > 0;
    } catch (SQLException e) {
      LogException.log(this.getClass().getName(), e);
    }

    return false;
  }

  public boolean deleteMajor(int id) {
    String sql = "DELETE FROM majors WHERE id=?";

    try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.setInt(1, id);

      return stmt.executeUpdate() > 0;
    } catch (SQLException e) {
      LogException.log(this.getClass().getName(), e);
    }

    return false;
  }
}
