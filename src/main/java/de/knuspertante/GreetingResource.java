package de.knuspertante;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello/{environment}")
@RequestScoped
public class GreetingResource {

  @PathParam("environment")
  private String environment;

  @GET
  @Path("/{helloMessage}")
  @Produces(MediaType.TEXT_PLAIN)
  public String hello(@PathParam("helloMessage") String message) {

    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Hello from RESTEasy Reactive");
    stringBuilder.append("\nEnvironment: ");
    stringBuilder.append(environment);
    stringBuilder.append("\nMessage: ");
    stringBuilder.append(message);

    printInstanceVariableFromPathParam();
    return stringBuilder.toString();
  }

  private void printInstanceVariableFromPathParam() {
    System.out.println(this.environment);
  }
}
