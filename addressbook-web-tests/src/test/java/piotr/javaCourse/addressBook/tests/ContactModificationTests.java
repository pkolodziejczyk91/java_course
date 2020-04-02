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
      app.getContactHelper().createContact(new ContactData().withFirstname("Piotr").withLastname("Kolodziejczyk"));
    }
    List<ContactData> before = app.getContactHelper().all();
    app.getContactHelper().selectContact(before.size() -1);
    app.getContactHelper().initContactModification();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstname("Piotr").withLastname("Kolodziejczyk");
    app.getContactHelper().fillContactForm(contact, false);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().returnToHomePage();
    List<ContactData> after = app.getContactHelper().all();

    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() -1);
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }
}
