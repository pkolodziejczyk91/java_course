package piotr.javaCourse.addressBook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import piotr.javaCourse.addressBook.model.ContactData;

import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("Piotr", "Kołodziejczyk"), false);
    app.getContactHelper().submitContactCreation();
    app.getNavigationHelper().returnToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();

    Assert.assertEquals(after.size(), before.size() +1);
  }
}
