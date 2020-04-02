package piotr.javaCourse.addressBook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import piotr.javaCourse.addressBook.model.ContactData;


import java.util.List;

public class ContactDeletionTests extends TestBase {

  @Test

  public void testContactDeletion() {
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Piotr", "Kołodziejczyk"));
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size() -1);
    app.getContactHelper().deleteContact();
    app.getContactHelper().acceptContactAlert();
    app.getNavigationHelper().returnToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();

    Assert.assertEquals(after.size(), before.size() -1);

    before.remove(before.size() -1);
    Assert.assertEquals(before, after);
  }
}
