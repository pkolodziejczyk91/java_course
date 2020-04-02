package piotr.javaCourse.addressBook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import piotr.javaCourse.addressBook.model.ContactData;

import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @Test

  public void testContactModification() {
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData(null, "Piotr","Kołodziejczyk"));
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size() -1);
    app.getContactHelper().initContactModification();
    ContactData contact = new ContactData("Piotr", "Kołodziejczyk");
    app.getContactHelper().fillContactForm(contact, false);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().returnToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();

    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() -1);
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }
}
