package br.com.joaogabriel.resource;

import br.com.joaogabriel.client.viacep.ViaCepClient;
import br.com.joaogabriel.client.viacep.response.AddressResponse;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/api/v1/zipcode")
@Produces(MediaType.APPLICATION_JSON)
public class ZipCodeResource {

    @RestClient
    private ViaCepClient viaCepClient;

    @GET
    @Path("/{zipCode}")
    public Response getAddressByZipCode(@PathParam("zipCode") String zipCode) {
        AddressResponse addressByZipCode = viaCepClient.getAddressByZipCode(zipCode);
        return Response.status(Response.Status.OK).entity(addressByZipCode).build();
    }
}
