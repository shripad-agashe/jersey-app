package helpers;


import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.rules.ExternalResource;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Application;

public class JerseyTestRule extends ExternalResource {
  private JerseyTest jerseyTest;

  public JerseyTestRule() {
    this.jerseyTest = new JerseyTest() {
      @Override
      protected Application configure() {
        ResourceConfig resourceConfig = new ResourceConfig();
        resourceConfig.register(getBinder());
        resourceConfig.packages("com.rs");
        resourceConfig.register(MultiPartFeature.class);
        return resourceConfig;
      }
    };
  }


  public AbstractBinder getBinder()
  {
    TestApplicationBinder binder = new TestApplicationBinder();
    return binder;
  }


  @Override
  public void before() throws Throwable {
    System.setProperty("app.env","test");
    String url = "jdbc:postgresql://localhost:9999/training";

    System.setProperty("db_url", url);
    System.setProperty("db_user","training");
    System.setProperty("db_password","training");
    this.jerseyTest.setUp();
  }

  @Override
  public void after() {
    try {
      this.jerseyTest.tearDown();
    } catch (Exception e) {
      throw new RuntimeException("failed to tear down JerseyTest.", e);
    }
  }

  public WebTarget getTarget(String path) {
    return this.jerseyTest.target(path);
  }


}
