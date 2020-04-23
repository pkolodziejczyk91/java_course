package piotr.javaCourse.addressBook.model;

import java.util.Objects;

public class ContactData {
  private int id;
  private String firstname;
  private String lastname;
  private String mobile;
  private String group;
  private String homePhone;
  private String mobilePhone;
  private String workPhone;
  private String allPhones;

  public String getAllPhones() {
    return allPhones;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }


  public String getHomePhone() {
    return homePhone;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public String getWorkPhone() {
    return workPhone;
  }

  public String getGroup() {
    return group;
  }


  public int getId() {
    return id;
  }

  public String getFirstname() {
    return firstname;
  }


  public String getLastname() {
    return lastname;
  }


  public String getMobile() {
    return mobile;
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }


  public ContactData withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }



  public ContactData withMobilephone(String mobilephone) {
    this.mobile = mobilephone;
    return this;
  }


  public ContactData withHomePhone(String home) {
    this.homePhone = homePhone;
    return this;
  }

  public ContactData withMobilePhone(String mobile) {
    this.mobilePhone = mobilePhone;
    return this;
  }

  public ContactData withWorkPhone(String work) {
    this.workPhone = workPhone;
    return this;
  }

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
