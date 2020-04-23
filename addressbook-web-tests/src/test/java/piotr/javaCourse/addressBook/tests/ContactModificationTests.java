package piotr.javaCourse.addressBook.tests;

import org.testng.annotations.Test;
import piotr.javaCourse.addressBook.model.ContactData;
import piotr.javaCourse.addressBook.model.Contacts;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.AssertJUnit.assertEquals;

public class ContactModificationTests extends TestBase {

  @Test

  public void testContactModification() {
    if (app.contact().isThereAContact()) {
      app.contact().createContact(new ContactData().withFirstname("Piotr").withLastname("Kolodziejczyk"));
    }
    Contacts before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new
            ContactData().withId(modifiedContact.getId()).withFirstname("Piotr").withLastname("Kolodziejczyk");
    app.contact().modify(contact);
    Contacts after = app.contact().all();
    assertEquals(after.size(), before.size());
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));

  }
}
