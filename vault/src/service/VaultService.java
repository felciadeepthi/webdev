package service;

import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import bean.VaultContent;

@Path("/vault")
public class VaultService {
  private static Map<String, VaultContent> storage = new HashMap<>();

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/content")
  public Response retrieveContent(@QueryParam("id") String id) {
    return Response.status(Response.Status.OK).entity(storage.get(id)).build();
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/content")
  public Response saveContent(VaultContent content) {
    storage.put(content.getJournal().get("id"), content);
    return Response.status(Response.Status.OK).build();
  }
}
