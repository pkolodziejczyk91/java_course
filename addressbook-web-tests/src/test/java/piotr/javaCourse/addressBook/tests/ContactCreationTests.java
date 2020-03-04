package piotr.javaCourse.addressBook.tests;

import org.testng.annotations.Test;
import piotr.javaCourse.addressBook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("Piotr", "Michał", "Kołodziejczyk", "Mr.", "pkolodziejczyk91@gmail.com", "111 111 111"));
    app.getContactHelper().submitContactCreation();
    app.getNavigationHelper().returnToHomePage();
  }
}
