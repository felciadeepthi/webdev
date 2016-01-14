package service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Map;
import javax.servlet.annotation.MultipartConfig;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@MultipartConfig
public class HelloService {

  @RequestMapping(value = "/hello",
      method = RequestMethod.GET)
  public ResponseEntity<Map<String, String>> getGreeting() {
    String greeting = "Hello from " + this.getClass().getSimpleName();
    return new ResponseEntity<Map<String, String>>(Collections.singletonMap("greeting", greeting), HttpStatus.OK);
  }

  @RequestMapping(value = "/pdf",
      method = RequestMethod.GET,
      produces = "application/pdf")
  public ResponseEntity<InputStreamResource> getPDF() throws IOException {
    ClassPathResource pdfFile = new ClassPathResource("Check Payment.pdf");
    return ResponseEntity.ok().body(new InputStreamResource(pdfFile.getInputStream()));
  }

  @RequestMapping(value = "/upload")
  public ResponseEntity<String> uploadFile(@RequestParam("binaryContent") MultipartFile multiPart) throws IOException {
    System.out.println(multiPart.getOriginalFilename());
    System.out.println(new String(multiPart.getBytes(), StandardCharsets.UTF_8));
    return new ResponseEntity<String>("Success", HttpStatus.OK);
  }

}
