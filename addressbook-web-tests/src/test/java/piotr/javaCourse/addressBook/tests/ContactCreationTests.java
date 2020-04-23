package piotr.javaCourse.addressBook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import piotr.javaCourse.addressBook.model.ContactData;
import piotr.javaCourse.addressBook.model.Contacts;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    Contacts before = app.contact().all();
    app.contact().initContactCreation();
    app.contact().fillContactForm(new ContactData().withFirstname("Piotr").withLastname("Kolodziejczyk"), true);
    app.contact().submitContactCreation();
    app.goTo().returnToHomePage();
    Contacts after = app.contact().all();

    Assert.assertEquals(after.size(), before.size() +1);

    assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt()))));
  }
}
