package br.com.joaogabriel.resource;

import jakarta.annotation.security.PermitAll;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/v1/public")
@Produces(MediaType.APPLICATION_JSON)
public class PublicResource {

    @GET
    @PermitAll
    public Response allowed() {
        return Response.status(Response.Status.OK).entity("Allowed").build();
    }
}
