package service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import bean.VaultContent;

public class VaultStoreClient {

  public static void main(String[] args) {
    WebTarget webTarget = ClientBuilder.newClient().target("http://localhost:8080/vault/rest/vault/content");
    VaultContent content = new VaultContent();
    String htmlContent = "<body><h1>content</h1></body>";
    String encodedHtmlContent = Base64.getEncoder().encodeToString(htmlContent.getBytes(StandardCharsets.UTF_8));
    content.setHtmlContent(encodedHtmlContent);
    Map<String, String> journal = new HashMap<>();
    journal.put("id", "1");
    content.setJournal(journal);
    webTarget.request().accept(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(content, MediaType.APPLICATION_JSON_TYPE), new GenericType<VaultContent>() {
    });
  }
}
