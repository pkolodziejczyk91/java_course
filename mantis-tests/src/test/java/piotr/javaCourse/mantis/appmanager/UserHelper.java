package piotr.javaCourse.mantis.appmanager;

import org.openqa.selenium.By;
import piotr.javaCourse.mantis.model.UserData;

public class UserHelper extends HelperBase {
  public UserHelper(ApplicationManager app) {
    super( app );
  }

  public void changePasswordFor(UserData user) {
    selectUserById(user.getId());
    resetPasswordForSelectedUser();
  }

  private void resetPasswordForSelectedUser() {
    wd.findElement( By.cssSelector("input[value='Nowe hasło']")).click();
  }

  private void selectUserById(int id) {
    wd.findElement(By.cssSelector("a[href*='user_id="+ id + "']")).click();
  }

}