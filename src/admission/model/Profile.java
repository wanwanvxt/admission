package admission.model;

public class Profile {
  
  private int id;
  private int candidateId;
  private boolean schoolReport;
  private boolean diploma;
  private double score;
  
  public int getId() {
    return id;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  
  public int getCandidateId() {
    return candidateId;
  }
  
  public void setCandidateId(int candidateId) {
    this.candidateId = candidateId;
  }
  
  public boolean isSchoolReport() {
    return schoolReport;
  }
  
  public void setSchoolReport(boolean schoolReport) {
    this.schoolReport = schoolReport;
  }
  
  public boolean isDiploma() {
    return diploma;
  }
  
  public void setDiploma(boolean diploma) {
    this.diploma = diploma;
  }
  
  public double getScore() {
    return score;
  }
  
  public void setScore(double score) {
    this.score = score;
  }
  
  public Profile(int id, int candidateId, boolean schoolReport, boolean diploma, double score) {
    this.id = id;
    this.candidateId = candidateId;
    this.schoolReport = schoolReport;
    this.diploma = diploma;
    this.score = score;
  }
  
  public Profile(int candidateId, boolean schoolReport, boolean diploma, double score) {
    this.candidateId = candidateId;
    this.schoolReport = schoolReport;
    this.diploma = diploma;
    this.score = score;
  }
  
  @Override
  public String toString() {
    return Double.toString(score);
  }
  
}
