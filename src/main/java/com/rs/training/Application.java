package com.rs.training;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.rs.training.di.ApplicationBinder;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/")
public class Application extends ResourceConfig {
  public Application() {
    register(JacksonFeature.class);
    register(JacksonJsonProvider.class);

    packages("com.rs.training");
    register(new ApplicationBinder());

    register(MultiPartFeature.class);

    property("jersey.config.beanValidation.enableOutputValidationErrorEntity.server", "true");
    property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
  }
}