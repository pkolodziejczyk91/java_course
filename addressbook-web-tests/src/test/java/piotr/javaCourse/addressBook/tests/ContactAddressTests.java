package piotr.javaCourse.addressBook.tests;

import org.testng.annotations.Test;
import piotr.javaCourse.addressBook.model.ContactData;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ContactAddressTests extends TestBase {

  @Test
  public void testContactAddress() {
    app.goTo().goToHomePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    assertThat((contact.getAddress()), equalTo(cleaned(contactInfoFromEditForm.getAddress())));

  }
  public static String cleaned(String email) {
    return email.replaceAll("\\s", "");
  }
}
