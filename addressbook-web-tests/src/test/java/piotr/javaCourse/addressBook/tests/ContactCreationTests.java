package piotr.javaCourse.addressBook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import piotr.javaCourse.addressBook.model.ContactData;
import piotr.javaCourse.addressBook.model.Contacts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class ContactCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validContactsFromJson() throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/resources/contacts.json")))) {
      String json = "";
      String line = reader.readLine();
      while (line != null) {
        json += line;
        line = reader.readLine();
      }
      Gson gson = new Gson();
      List<ContactData> contacts = gson.fromJson(json, new TypeToken<List<ContactData>>(){}.getType());
      return contacts.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
    }
  }


  @Test(dataProvider = "validContactsFromJson")
  public void testContactCreation() {
    Contacts before = app.db().contacts();
    app.contact().initContactCreation();
    File photo = new File("src/test/resources/LOGO_qa-courses.png");
    app.contact().fillContactForm(
            new ContactData().withFirstname("Piotr").withLastname("Kolodziejczyk").withPhoto(photo), true);
    app.contact().submitContactCreation();
    app.goTo().returnToHomePage();
    Contacts after = app.db().contacts();

    Assert.assertEquals(after.size(), before.size() +1);

//    assertThat(after, equalTo(
//            before.withAdded(contact.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt()))));
    verifyGroupListInUi();
  }
}
