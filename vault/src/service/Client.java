import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class Client {

  public static void main(String[] args) throws ClientProtocolException, IOException {
    CloseableHttpClient httpClient = HttpClients.createDefault();
    HttpPost uploadFile = new HttpPost("http://localhost:8080/springmvc/upload");

    MultipartEntityBuilder builder = MultipartEntityBuilder.create();
    builder.addTextBody("meta", "1", ContentType.TEXT_PLAIN);
    String html = "<head></head>";
    builder.addBinaryBody("binaryContent", html.getBytes(StandardCharsets.UTF_8), ContentType.APPLICATION_OCTET_STREAM, "email.html");
    HttpEntity multipart = builder.build();

    uploadFile.setEntity(multipart);

    CloseableHttpResponse response = httpClient.execute(uploadFile);
    response.getEntity();

  }

}
