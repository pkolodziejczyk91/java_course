package piotr.javaCourse.addressBook.model;

public class ContactData {
  private final String firstname;
  private final String middlename;
  private final String lastname;
  private final String title;
  private final String email;
  private final String mobile;

  public String getGroup() {
    return group;
  }

  private String group;

  public ContactData(String firstname, String middlename, String lastname, String title, String email, String mobile, String group) {
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.title = title;
    this.email = email;
    this.mobile = mobile;
    this.group = group;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getMiddlename() {
    return middlename;
  }

  public String getLastname() {
    return lastname;
  }

  public String getTitle() {
    return title;
  }

  public String getEmail() {
    return email;
  }

  public String getMobile() {
    return mobile;
  }

}
