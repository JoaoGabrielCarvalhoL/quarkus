package br.com.joaogabriel.resource;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/api/v1/hello")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class HelloResource {

    private final String hello;

    public HelloResource(@ConfigProperty(name = "quarkus.hello") String hello) {
        this.hello = hello;
    }

    @GET
    public Response hello() {
        return Response.ok(hello).build();
    }
}
