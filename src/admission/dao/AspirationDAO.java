package admission.dao;

import admission.model.Aspiration;
import admission.util.LogException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AspirationDAO {

  public Aspiration getAspirationByCandidateId(int candidateId) {
    Aspiration aspiration = null;
    String sql = "SELECT * FROM aspirations WHERE candidate_id=?";

    try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.setInt(1, candidateId);

      ResultSet rs = stmt.executeQuery();
      if (rs.next()) {
        aspiration = new Aspiration(
                rs.getInt("id"),
                rs.getInt("candidate_id"),
                rs.getInt("major_id"),
                rs.getString("status")
        );
      }
    } catch (SQLException e) {
      LogException.log(this.getClass().getName(), e);
    }

    return aspiration;
  }

  public List<Aspiration> getAspirationsByMajorId(int majorId) {
    List<Aspiration> aspirations = new ArrayList<>();

    String sql = "SELECT * FROM aspirations WHERE major_id=?";

    try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.setInt(1, majorId);

      ResultSet rs = stmt.executeQuery();
      while (rs.next()) {
        Aspiration aspiration = new Aspiration(
                rs.getInt("id"),
                rs.getInt("candidate_id"),
                rs.getInt("major_id"),
                rs.getString("status")
        );
        aspirations.add(aspiration);
      }
    } catch (SQLException e) {
      LogException.log(this.getClass().getName(), e);
    }

    return aspirations;
  }

  public boolean addAspiration(Aspiration aspiration) {
    String sql = "INSERT INTO aspirations (candidate_id, major_id, status) VALUES (?,?,?)";

    try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.setInt(1, aspiration.getCandidateId());
      stmt.setInt(2, aspiration.getMajorId());
      stmt.setString(3, aspiration.getStatus());

      return stmt.executeUpdate() > 0;
    } catch (SQLException e) {
      LogException.log(this.getClass().getName(), e);
    }

    return false;
  }

  public boolean updateAspiration(Aspiration aspiration) {
    String sql = "UPDATE aspirations SET major_id=?, status=? WHERE candidate_id=?";

    try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.setInt(1, aspiration.getMajorId());
      stmt.setString(2, aspiration.getStatus());
      stmt.setInt(3, aspiration.getCandidateId());

      return stmt.executeUpdate() > 0;
    } catch (SQLException e) {
      LogException.log(this.getClass().getName(), e);
    }

    return false;
  }

  ///aspiration tự động xoá khi xoá cadidate/major
}
