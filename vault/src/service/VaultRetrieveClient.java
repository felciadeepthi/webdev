package service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import bean.VaultContent;

public class VaultRetrieveClient {

  public static void main(String[] args) {
    WebTarget webTarget = ClientBuilder.newClient().target("http://localhost:8080/vault/rest/vault/content");
    VaultContent content = webTarget.queryParam("id", "1").request(MediaType.APPLICATION_JSON_TYPE).get(new GenericType<VaultContent>() {
    });
    System.out.println(new String(Base64.getDecoder().decode(content.getHtmlContent()), StandardCharsets.UTF_8));
  }
}
