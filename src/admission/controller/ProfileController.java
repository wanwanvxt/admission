package admission.controller;

import admission.dao.ProfileDAO;
import admission.model.Profile;

public class ProfileController {

  private ProfileDAO profileDAO;

  public ProfileController() {
    profileDAO = new ProfileDAO();
  }

  public Profile getProfileByCandidateId(int candidateId) {
    return profileDAO.getProfileByCandidateId(candidateId);
  }

  public boolean addOrUpdateProfile(Profile profile) {
    Profile profileToCheck = getProfileByCandidateId(profile.getCandidateId());
    if (profileToCheck == null) {
      return addProfile(profile);
    }

    return updateProfile(profile);
  }

  public boolean addProfile(Profile profile) {
    return profileDAO.addProfile(profile);
  }

  public boolean updateProfile(Profile profile) {
    return profileDAO.updateProfile(profile);
  }
}
