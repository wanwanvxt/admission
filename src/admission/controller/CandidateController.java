package admission.controller;

import admission.dao.CandidateDAO;
import admission.model.Candidate;
import java.util.List;

public class CandidateController {

  private CandidateDAO candidateDAO;

  public CandidateController() {
    candidateDAO = new CandidateDAO();
  }

  public List<Candidate> getAllCandidates() {
    return candidateDAO.getAllCandidates();
  }

  public Candidate getCandidateById(int id) {
    return candidateDAO.getCandidateById(id);
  }

  public int addCandidate(Candidate candidate) {
    return candidateDAO.addCandidate(candidate);
  }

  public boolean updateCandidate(Candidate candidate) {
    return candidateDAO.updateCandidate(candidate);
  }

  public boolean deleteCandidate(int id) {
    return candidateDAO.deleteCandidate(id);
  }
}
