package admission.controller;

import admission.dao.AspirationDAO;
import admission.model.Aspiration;
import java.util.List;

public class AspirationController {

  private AspirationDAO aspirationDAO;

  public AspirationController() {
    aspirationDAO = new AspirationDAO();
  }

  public Aspiration getAspirationByCandidateId(int candidateId) {
    return aspirationDAO.getAspirationByCandidateId(candidateId);
  }
  
  public List<Aspiration> getAspirationsByMajorId(int majorId) {
    return aspirationDAO.getAspirationsByMajorId(majorId);
  }

  public boolean addOrUpdateAspiration(Aspiration aspiration) {
    Aspiration aspirationToCheck = getAspirationByCandidateId(aspiration.getCandidateId());
    if (aspirationToCheck == null) {
      return addAspiration(aspiration);
    }

    return updateAspiration(aspiration);
  }

  public boolean addAspiration(Aspiration aspiration) {
    return aspirationDAO.addAspiration(aspiration);
  }

  public boolean updateAspiration(Aspiration aspiration) {
    return aspirationDAO.updateAspiration(aspiration);
  }
}
