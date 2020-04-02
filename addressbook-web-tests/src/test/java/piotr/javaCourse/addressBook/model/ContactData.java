package piotr.javaCourse.addressBook.model;

import java.util.Objects;

public class ContactData {
  private final String id;
  private final String firstname;
//  private final String middlename;
  private final String lastname;
//  private final String title;
//  private final String email;
//  private final String mobile;

  public String getGroup() {
    return group;
  }

  private String group;


  public String getId() {
    return id;
  }

  public ContactData(String id, String firstname, String lastname) {
    this.id = id;
    this.firstname = firstname;
//    this.middlename = middlename;
    this.lastname = lastname;
//    this.title = title;
//    this.email = email;
//    this.mobile = mobile;
    this.group = group;
  }

  public String getFirstname() {
    return firstname;
  }

//  public String getMiddlename() {
//    return middlename;
//  }

  public String getLastname() {
    return lastname;
  }

//  public String getTitle() {
//    return title;
//  }

//  public String getEmail() {
//    return email;
//  }

//  public String getMobile() {
//    return mobile;
//  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return Objects.equals(id, that.id) &&
            Objects.equals(firstname, that.firstname) &&
            Objects.equals(lastname, that.lastname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstname, lastname);
  }
}
