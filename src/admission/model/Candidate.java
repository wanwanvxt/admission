package admission.model;

import java.sql.Date;

public class Candidate {

  private int id;
  private String name;
  private boolean gender;
  private Date birthdate;
  private String address;
  private String email;
  private String phoneNumber;
  private String citizenId;

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

  public boolean getGender() {
    return gender;
  }

  public void setGender(boolean gender) {
    this.gender = gender;
  }

  public Date getBirthdate() {
    return birthdate;
  }

  public void setBirthdate(Date birthdate) {
    this.birthdate = birthdate;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getCitizenId() {
    return citizenId;
  }

  public void setCitizenId(String citizenId) {
    this.citizenId = citizenId;
  }

  public Candidate(int id, String name, boolean gender, Date birthdate, String address, String email, String phoneNumber, String citizenId) {
    this.id = id;
    this.name = name;
    this.gender = gender;
    this.birthdate = birthdate;
    this.address = address;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.citizenId = citizenId;
  }

  public Candidate(String name, boolean gender, Date birthdate, String address, String email, String phoneNumber, String citizenId) {
    this.name = name;
    this.gender = gender;
    this.birthdate = birthdate;
    this.address = address;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.citizenId = citizenId;
  }

  @Override
  public String toString() {
    return name;
  }

}
