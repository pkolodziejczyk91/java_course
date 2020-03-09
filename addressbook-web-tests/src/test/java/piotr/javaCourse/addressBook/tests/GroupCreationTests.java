package piotr.javaCourse.addressBook.tests;

import org.testng.annotations.*;
import piotr.javaCourse.addressBook.model.GroupData;


public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().createGroup(new GroupData("test1", null, null));
  }
}
