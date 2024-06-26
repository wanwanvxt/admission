package admission.controller;

import admission.dao.UserDAO;
import admission.model.User;
import java.util.List;

public class UserController {

  private User currentUser;
  private UserDAO userDAO;

  public UserController() {
    userDAO = new UserDAO();
  }

  public UserController(User currentUser) {
    this.currentUser = currentUser;
    userDAO = new UserDAO();
  }

  public User login(String username, String password) {
    User user = userDAO.getUserByUsername(username);
    if (user != null && user.getPassword().equals(password)) {
      return user;
    }

    return null;
  }

  public boolean register(User user) {
    if (currentUser.getRole().equals("admin")) {
      return userDAO.addUser(user);
    }

    return false;
  }

  public List<User> getAllUsers() {
    return userDAO.getAllUsers();
  }

  public boolean updateUser(User user) {
    if (currentUser.getRole().equals("admin")) {
      return userDAO.updateUser(user);
    }

    return false;
  }
  
  public boolean deleteUser(int id) {
    if (currentUser.getRole().equals("admin")) {
      return userDAO.deleteUser(id);
    }
    
    return false;
  }
}
