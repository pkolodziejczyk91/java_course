package piotr.javaCourse.addressBook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import piotr.javaCourse.addressBook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test(enabled = false)
  public void testContactCreation() {
    List<ContactData> before = app.getContactHelper().all();
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactData().withFirstname("Piotr").withLastname("Kolodziejczyk"));
    app.getContactHelper().submitContactCreation();
    app.getNavigationHelper().returnToHomePage();
    List<ContactData> after = app.getContactHelper().all();

    Assert.assertEquals(after.size(), before.size() +1);

    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2)->Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before,after);
  }
}
