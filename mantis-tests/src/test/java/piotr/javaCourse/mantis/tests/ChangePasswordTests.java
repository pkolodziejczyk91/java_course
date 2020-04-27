package piotr.javaCourse.mantis.tests;

import org.testng.annotations.AfterMethod;
import piotr.javaCourse.mantis.appmanager.HttpSession;
import piotr.javaCourse.mantis.model.MailMessage;
import piotr.javaCourse.mantis.model.UserData;
import piotr.javaCourse.mantis.model.Users;

import java.util.List;

public class ChangePasswordTests extends TestBase {
  Users users = app.db().users();
  UserData user = users.iterator().next();
    if (user.getEmail().equals( "root@localhost" )) {
    user = users.stream().skip(user.getId()).iterator().next();
  }
  String username = user.getUsername();
  String password = "password";
  String email = user.getEmail();
      app.newSession().loginUI( "administrator", "root" );
      app.goTo().manageUsersPage();
      app.mail().start();
      app.user().changePasswordFor(user);

  List<MailMessage> mailMessages = app.mail().waitForMail( 1, 10000 );
  String confirmationLink = findConfirmationLink( mailMessages, email );
      app.registration().finish(confirmationLink, password );
  HttpSession session = app.newSession();
  assertTrue(session.login(username, password));
  assertTrue(session.isLoggedInAs(username));
}

  private String findConfirmationLink(List<MailMessage> mailMessages, String email) {

    MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals( email ) ).findFirst().get();
    VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
    return regex.getText(mailMessage.text);
  }

  @AfterMethod(alwaysRun = true)
  public void stopMailServer() {
    app.mail().stop();
  }
}

}
