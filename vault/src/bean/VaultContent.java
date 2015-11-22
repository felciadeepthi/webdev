package bean;

import java.util.Map;

public class VaultContent {

  private Map<String, String> journal;
  private String htmlContent;

  public final String getHtmlContent() {
    return htmlContent;
  }

  public final Map<String, String> getJournal() {
    return journal;
  }

  public final void setHtmlContent(String htmlContent) {
    this.htmlContent = htmlContent;
  }

  public final void setJournal(Map<String, String> journal) {
    this.journal = journal;
  }

  @Override
  public String toString() {
    return "VaultContent [" + (journal != null ? "journal=" + journal + ", " : "") + (htmlContent != null ? "htmlContent=" + htmlContent : "") + "]";
  }

}
