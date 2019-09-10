package com.rs.training.endpoints;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@Path("/hello-world")
public class HelloWorldEndPoint {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response getHelloWorld(){
    Map map = new HashMap<>();
    map.put("hello","world");
    return Response.ok().entity(map).build();
  }
}
