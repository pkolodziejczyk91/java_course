package piotr.javaCourse.rest.appmanager;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.apache.http.client.fluent.Request;
import org.apache.http.message.BasicNameValuePair;
import piotr.javaCourse.rest.module.Issue;
import java.io.IOException;
import java.util.Set;
import org.apache.http.client.fluent.Executor;


public class IssueHelper {
  private final ApplicationManager app;

  public IssueHelper(ApplicationManager app) {
    this.app = app;
  }

  public int create(Issue newIssue) throws IOException {
    String json = getExecutor().auth("28accbe43ea112d9feb328d2c00b3eed", "").execute(Request.Post("http://demo.bugify.com/api/issues.json")

            .bodyForm( new BasicNameValuePair( "subject", newIssue.getSubject() ),
                    new BasicNameValuePair( "description", newIssue.getDescription() )))
            .returnContent().asString();
    JsonElement parsed = new JsonParser().parse( json );
    return parsed.getAsJsonObject().get( "issue_id" ).getAsInt();
  }

  public Set<Issue> all() throws IOException {

    String json = getExecutor().auth("228accbe43ea112d9feb328d2c00b3eed", "").execute(Request.Get("http://demo.bugify.com/api/issues.json") ).returnContent().asString();
    JsonElement parsed = new JsonParser().parse( json );
    JsonElement issues = parsed.getAsJsonObject().get( "issues" );
    return new Gson().fromJson( issues, new TypeToken<Set<Issue>>(){}.getType());

  }

  public Set<Issue> getIssueById(int issueId) throws IOException {

    String json = getExecutor().auth( "28accbe43ea112d9feb328d2c00b3eed", "" ).execute(Request.Get( "http://demo.bugify.com/api/issues/" + issueId + ".json" ) ).returnContent().asString();
    JsonElement parsed = new JsonParser().parse( json );
    JsonElement issues = parsed.getAsJsonObject().get( "issues" );
    return new Gson().fromJson( issues, new TypeToken<Set<Issue>>(){}.getType());
  }

  public Executor getExecutor() {
    return org.apache.http.client.fluent.Executor.newInstance();
  }
}

