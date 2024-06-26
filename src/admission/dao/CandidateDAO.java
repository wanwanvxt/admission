package admission.dao;

import admission.model.Candidate;
import admission.util.LogException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CandidateDAO {
  
  public List<Candidate> getAllCandidates() {
    List<Candidate> candidates = new ArrayList<>();
    String sql = "SELECT * FROM candidates";
    
    try (Connection conn = DBConnection.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
      while (rs.next()) {
        Candidate candidate = new Candidate(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getBoolean("gender"),
                rs.getDate("birthdate"),
                rs.getString("address"),
                rs.getString("email"),
                rs.getString("phone_number"),
                rs.getString("citizen_id")
        );
        candidates.add(candidate);
      }
    } catch (SQLException e) {
      LogException.log(this.getClass().getName(), e);
    }
    
    return candidates;
  }
  
  public Candidate getCandidateById(int id) {
    Candidate candidate = null;
    String sql = "SELECT * FROM candidates WHERE id=?";
    
    try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareCall(sql)) {
      stmt.setInt(1, id);
      
      ResultSet rs = stmt.executeQuery();
      while (rs.next()) {
        candidate = new Candidate(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getBoolean("gender"),
                rs.getDate("birthdate"),
                rs.getString("address"),
                rs.getString("email"),
                rs.getString("phone_number"),
                rs.getString("citizen_id")
        );
      }
    } catch (SQLException e) {
      LogException.log(this.getClass().getName(), e);
    }
    
    return candidate;
  }

  /// cần lấy id để có thể thêm được profile/aspiration
  public int addCandidate(Candidate candidate) {
    int insertedId = 0;
    String sql = "INSERT INTO candidates (name, gender, birthdate, address, email, phone_number, citizen_id) VALUES (?,?,?,?,?,?,?)";
    
    try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareCall(sql)) {
      stmt.setString(1, candidate.getName());
      stmt.setBoolean(2, candidate.getGender());
      stmt.setDate(3, candidate.getBirthdate());
      stmt.setString(4, candidate.getAddress());
      stmt.setString(5, candidate.getEmail());
      stmt.setString(6, candidate.getPhoneNumber());
      stmt.setString(7, candidate.getCitizenId());
      
      int insertedRow = stmt.executeUpdate();
      if (insertedRow > 0) {
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
          insertedId = rs.getInt(1);
        }
      }
    } catch (SQLException e) {
      LogException.log(this.getClass().getName(), e);
    }
    
    return insertedId;
  }
  
  public boolean updateCandidate(Candidate candidate) {
    String sql = "UPDATE candidates SET name=?, gender=?, birthdate=?, address=?, email=?, phone_number=?, citizen_id=? WHERE id=?";
    
    try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareCall(sql)) {
      stmt.setString(1, candidate.getName());
      stmt.setBoolean(2, candidate.getGender());
      stmt.setDate(3, candidate.getBirthdate());
      stmt.setString(4, candidate.getAddress());
      stmt.setString(5, candidate.getEmail());
      stmt.setString(6, candidate.getPhoneNumber());
      stmt.setString(7, candidate.getCitizenId());
      stmt.setInt(8, candidate.getId());
      
      return stmt.executeUpdate() > 0;
    } catch (SQLException e) {
      LogException.log(this.getClass().getName(), e);
    }
    
    return false;
  }
  
  public boolean deleteCandidate(int id) {
    String sql = "DELETE FROM candidates WHERE id=?";
    
    try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareCall(sql)) {
      stmt.setInt(1, id);
      
      return stmt.executeUpdate() > 0;
    } catch (SQLException e) {
      LogException.log(this.getClass().getName(), e);
    }
    
    return false;
  }
}
