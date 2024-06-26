package admission.model;

public class Major {

  private int id;
  private String name;
  private String desc;
  private int falcultyId;
  private double baseScore;
  private int quota;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public int getFalcultyId() {
    return falcultyId;
  }

  public void setFalcultyId(int falcultyId) {
    this.falcultyId = falcultyId;
  }

  public double getBaseScore() {
    return baseScore;
  }

  public void setBaseScore(double baseScore) {
    this.baseScore = baseScore;
  }

  public int getQuota() {
    return quota;
  }

  public void setQuota(int quota) {
    this.quota = quota;
  }

  public Major(int id, String name, String desc, int falcultyId, double baseScore, int quota) {
    this.id = id;
    this.name = name;
    this.desc = desc;
    this.falcultyId = falcultyId;
    this.baseScore = baseScore;
    this.quota = quota;
  }

  public Major(int id, String name, String desc, int falcultyId, int quota) {
    this.id = id;
    this.name = name;
    this.desc = desc;
    this.falcultyId = falcultyId;
    this.quota = quota;
  }

  public Major(String name, String desc, int falcultyId, int quota) {
    this.name = name;
    this.desc = desc;
    this.falcultyId = falcultyId;
    this.quota = quota;
  }

  @Override
  public String toString() {
    return name;
  }

}
