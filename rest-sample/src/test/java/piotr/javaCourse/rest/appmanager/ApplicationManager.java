package piotr.javaCourse.rest.appmanager;

public class ApplicationManager {

  private IssueHelper issueHelper;

  public ApplicationManager() {
  }

  public IssueHelper issue() {
    if (issueHelper == null) {
      issueHelper = new IssueHelper(this);
    }
    return issueHelper;
  }
}
