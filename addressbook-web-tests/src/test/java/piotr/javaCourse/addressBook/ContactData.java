package piotr.javaCourse.addressBook;

public class ContactData {
  private final String firstname;
  private final String middlename;
  private final String lastname;
  private final String title;
  private final String email;
  private final String mobile;

  public ContactData(String firstname, String middlename, String lastname, String title, String email, String mobile) {
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.title = title;
    this.email = email;
    this.mobile = mobile;
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
