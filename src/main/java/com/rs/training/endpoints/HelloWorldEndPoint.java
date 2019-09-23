package com.rs.training.endpoints;

import com.rs.training.dao.TestDao;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Path("/hello-world")
public class HelloWorldEndPoint {

  private TestDao testDao;

  @Inject
  public HelloWorldEndPoint(TestDao testDao){

    this.testDao = testDao;
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response getHelloWorld(){
    Map map = new HashMap<>();
    map.put("hello","world");
    try {
      String name = testDao.getName(1);
      map.put("name", name);
    } catch (SQLException e) {
      e.printStackTrace();
      map.put("name", "notfound");
    }
    return Response.ok().entity(map).build();
  }
}
