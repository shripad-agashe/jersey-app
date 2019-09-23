package com.rs.training.endpoints;

import helpers.JerseyTestRule;
import org.junit.ClassRule;
import org.junit.Test;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import static org.junit.Assert.*;

public class HelloWorldEndPointTest {
  @ClassRule
  public static JerseyTestRule jerseyTestRule = new JerseyTestRule();

  @Test
  public void shouldReturnData(){
    WebTarget target = jerseyTestRule.getTarget("/hello-world");
    Invocation.Builder request = target.request();
    Response response = request.get();
    assertEquals("Successful Response",200,response.getStatus());
    assertEquals("Successful Response","sdsd",response.readEntity(String.class));



  }

}