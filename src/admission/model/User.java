package admission.model;

public class User {

  private int id;
  private String username;
  private String password;
  private String role;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public String getRole() {
    return role;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public User(int id, String username, String password, String role) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.role = role;
  }

  public User(String username, String password, String role) {
    this.username = username;
    this.password = password;
    this.role = role;
  }

  @Override
  public String toString() {
    return username;
  }

}
