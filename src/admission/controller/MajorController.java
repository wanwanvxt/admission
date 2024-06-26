package admission.controller;

import admission.dao.MajorDAO;
import admission.model.Major;
import java.util.List;

public class MajorController {

  private MajorDAO majorDAO;

  public MajorController() {
    majorDAO = new MajorDAO();
  }

  public List<Major> getAllMajors() {
    return majorDAO.getAllMajors();
  }

  public boolean addMajor(Major major) {
    return majorDAO.addMajor(major);
  }

  public boolean updateMajor(Major major) {
    return majorDAO.updateMajor(major);
  }

  public boolean deleteMajor(int id) {
    return majorDAO.deleteMajor(id);
  }
}
