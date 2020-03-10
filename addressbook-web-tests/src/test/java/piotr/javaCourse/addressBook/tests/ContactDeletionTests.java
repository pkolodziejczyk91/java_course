package piotr.javaCourse.addressBook.tests;

import org.testng.annotations.Test;
import piotr.javaCourse.addressBook.model.ContactData;

public class ContactDeletionTests extends TestBase {

  @Test

  public void testContactDeletion() {
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Piotr", "Michał", "Kołodziejczyk", "Mr.", "pkolodziejczyk91@gmail.com", "111 111 111", "test1"));
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteContact();
    app.getContactHelper().acceptContactAlert();
  }
}
