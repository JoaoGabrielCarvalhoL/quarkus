package br.com.joaogabriel.resource;

import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.SecurityContext;

@Path("/api/v1/private")
@Produces(MediaType.APPLICATION_JSON)
public class PrivateResource {

    @GET
    @RolesAllowed("ADMIN")
    public Response allowed(@Context SecurityContext securityContext) {
        return Response.status(Response.Status.OK).entity("Permission granted for: " +
                securityContext.getUserPrincipal().getName()).build();
    }
}
