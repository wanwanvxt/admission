package admission.model;

public class Aspiration {

  private int id;
  private int candidateId;
  private int majorId;
  private String status;

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

  public int getMajorId() {
    return majorId;
  }

  public void setMajorId(int majorId) {
    this.majorId = majorId;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Aspiration(int id, int candidateId, int majorId, String status) {
    this.id = id;
    this.candidateId = candidateId;
    this.majorId = majorId;
    this.status = status;
  }

  public Aspiration(int candidateId, int majorId, String status) {
    this.candidateId = candidateId;
    this.majorId = majorId;
    this.status = status;
  }

  @Override
  public String toString() {
    return status;
  }

}
