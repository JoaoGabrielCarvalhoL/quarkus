package br.com.joaogabriel.resource;

import io.quarkus.security.Authenticated;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.SecurityContext;

@Path("/api/v1/authenticated")
@Authenticated
@Produces(MediaType.APPLICATION_JSON)
public class EndpointAuthenticatedKeycloak {

    @GET
    public Response response(@Context SecurityContext securityContext) {
        return Response.status(Response.Status.OK).entity(securityContext.getUserPrincipal()).build();

    }
}
