package admission.dao;

import admission.model.User;
import admission.util.LogException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

  public User getUserByUsername(String username) {
    User user = null;
    String sql = "SELECT * FROM users WHERE username=?";

    try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareCall(sql)) {
      stmt.setString(1, username);
      ResultSet rs = stmt.executeQuery();

      while (rs.next()) {
        user = new User(
                rs.getInt("id"),
                rs.getString("username"),
                rs.getString("password"),
                rs.getString("role")
        );
      }

    } catch (SQLException e) {
      LogException.log(this.getClass().getName(), e);
    }

    return user;
  }

  public List<User> getAllUsers() {
    List<User> users = new ArrayList<>();
    String sql = "SELECT * FROM users";

    try (Connection conn = DBConnection.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
      while (rs.next()) {
        User user = new User(
                rs.getInt("id"),
                rs.getString("username"),
                rs.getString("password"),
                rs.getString("role")
        );
        users.add(user);
      }
    } catch (SQLException e) {
      LogException.log(this.getClass().getName(), e);
    }

    return users;
  }

  public boolean addUser(User user) {
    String sql = "INSERT INTO users (username, password, role) VALUES (?,?,?)";

    try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.setString(1, user.getUsername());
      stmt.setString(2, user.getPassword());
      stmt.setString(3, user.getRole());

      return stmt.executeUpdate() > 0;
    } catch (SQLException e) {
      LogException.log(this.getClass().getName(), e);
    }

    return false;
  }

  public boolean updateUser(User user) {
    String sql = "UPDATE users SET username=?, password=?, role=? WHERE id=?";

    try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.setString(1, user.getUsername());
      stmt.setString(2, user.getPassword());
      stmt.setString(3, user.getRole());
      stmt.setInt(4, user.getId());

      return stmt.executeUpdate() > 0;
    } catch (SQLException e) {
      LogException.log(this.getClass().getName(), e);
    }

    return false;
  }

  public boolean deleteUser(int id) {
    String sql = "DELETE FROM users WHERE id=?";

    try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.setInt(1, id);

      return stmt.executeUpdate() > 0;
    } catch (SQLException e) {
      LogException.log(this.getClass().getName(), e);
    }

    return false;
  }
}
