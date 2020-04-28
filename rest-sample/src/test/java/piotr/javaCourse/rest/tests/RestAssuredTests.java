package piotr.javaCourse.rest.tests;


import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import piotr.javaCourse.rest.module.Issue;

import java.io.IOException;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class RestAssuredTests extends TestBase{

  @BeforeMethod

  public void ensurePreconditions() throws IOException {

    Set<Issue> issues = app.issue().all();
    for (Issue issue : issues) {
      skipIfNotFixed(issue.getId());
    }
  }

  @Test
  public void testCreateIssue()throws Exception{
    Set<Issue> oldIssues = getIssues();
    Issue newIssue = new Issue().withSubject("Test issue").withDescription("New test issue");
    int issueId = createIssue(newIssue);
    Set<Issue> newIssues = getIssues();
    oldIssues.add(newIssue.withId(issueId));
    assertEquals(newIssue, oldIssues);

  }

  private int createIssue(Issue newIssue) {
    return 0;
  }

  private Set<Issue> getIssues() {
    return null;
  }
}
