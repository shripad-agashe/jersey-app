package com.rs.training;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
  public static final String BASE_URI = "http://0.0.0.0";

  public static String port = "9090";

  public static HttpServer startServer() {
    final ResourceConfig rc = new Application();

    Logger l = Logger.getLogger("org.glassfish.grizzly.http.server.HttpHandler");
    l.setLevel(Level.FINE);
    l.setUseParentHandlers(false);
    ConsoleHandler ch = new ConsoleHandler();
    ch.setLevel(Level.ALL);
    l.addHandler(ch);

    String url = BASE_URI + ":" + port;
    System.out.println(url);
    return GrizzlyHttpServerFactory.createHttpServer(URI.create(url), rc);
  }


  public static void main(String[] args) throws IOException {

    final HttpServer server = startServer();
    System.out.println("Started Server");
  }
}
