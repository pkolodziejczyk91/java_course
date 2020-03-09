package piotr.javaCourse.addressBook.tests;

import org.testng.annotations.Test;
import piotr.javaCourse.addressBook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test

  public void testContactModification() {
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Michal", "Piotr", "Kołodziejczyk", "Mr.", "pkolodziejczyk91@gmail.com", "111 111 111", null), false);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().returnToHomePage();
  }
}
