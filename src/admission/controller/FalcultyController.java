package admission.controller;

import admission.dao.FalcultyDAO;
import admission.model.Falculty;
import java.util.List;

public class FalcultyController {

  private FalcultyDAO falcultyDAO;

  public FalcultyController() {
    falcultyDAO = new FalcultyDAO();
  }

  public List<Falculty> getAllFalculties() {
    return falcultyDAO.getAllFalculties();
  }

  public boolean addFalculty(Falculty falculty) {
    return falcultyDAO.addFalculty(falculty);
  }
  
  public boolean updateFalculty(Falculty falculty) {
    return falcultyDAO.updateFalculty(falculty);
  }
  
  public boolean deleteFalculty(int id) {
    return falcultyDAO.deleteFalculty(id);
  }
}
