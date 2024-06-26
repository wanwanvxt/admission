package admission.dao;

import admission.model.Profile;
import admission.util.LogException;
import java.sql.*;

public class ProfileDAO {

  public Profile getProfileByCandidateId(int candidateId) {
    Profile profile = null;
    String sql = "SELECT * FROM profiles WHERE candidate_id=?";

    try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.setInt(1, candidateId);

      ResultSet rs = stmt.executeQuery();
      if (rs.next()) {
        profile = new Profile(
                rs.getInt("id"),
                rs.getInt("candidate_id"),
                rs.getBoolean("school_report"),
                rs.getBoolean("diploma"),
                rs.getDouble("score")
        );
      }
    } catch (SQLException e) {
      LogException.log(this.getClass().getName(), e);
    }

    return profile;
  }

  public boolean addProfile(Profile profile) {
    String sql = "INSERT INTO profiles (candidate_id, school_report, diploma, score) VALUES (?,?,?,?)";

    try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.setInt(1, profile.getCandidateId());
      stmt.setBoolean(2, profile.isSchoolReport());
      stmt.setBoolean(3, profile.isDiploma());
      stmt.setDouble(4, profile.getScore());

      return stmt.executeUpdate() > 0;
    } catch (SQLException e) {
      LogException.log(this.getClass().getName(), e);
    }

    return false;
  }

  public boolean updateProfile(Profile profile) {
    String sql = "UPDATE profiles SET school_report=?, diploma=?, score=? WHERE candidate_id=?";

    try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.setBoolean(1, profile.isSchoolReport());
      stmt.setBoolean(2, profile.isDiploma());
      stmt.setDouble(3, profile.getScore());
      stmt.setInt(4, profile.getCandidateId());

      return stmt.executeUpdate() > 0;
    } catch (SQLException e) {
      LogException.log(this.getClass().getName(), e);
    }

    return false;
  }

  ///profile tự động xoá khi xoá candidate
}
