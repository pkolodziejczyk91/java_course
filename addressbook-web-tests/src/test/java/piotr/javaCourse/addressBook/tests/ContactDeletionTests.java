package piotr.javaCourse.addressBook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import piotr.javaCourse.addressBook.model.ContactData;
import piotr.javaCourse.addressBook.model.Contacts;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.AssertJUnit.assertEquals;

public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.contact().all().size() == 0) {
      app.contact().createContact(new ContactData().withFirstname("Piotr").withLastname("Kolodziejczyk"));
    }
  }

    @Test
    public void testContactDeletion() {

      Contacts before = app.contact().all();
      ContactData deletedContact = before.iterator().next();
      app.contact().delete(deletedContact);
      Contacts after = app.contact().all();
      assertEquals(after.size(), before.size() - 1);
      assertThat(after, equalTo(before.without(deletedContact)));
    }
  }
