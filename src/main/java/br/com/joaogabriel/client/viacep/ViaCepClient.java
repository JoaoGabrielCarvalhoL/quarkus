package br.com.joaogabriel.client.viacep;

import br.com.joaogabriel.client.viacep.response.AddressResponse;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

/**
 * RegisterRestClient: allows Quarkus to know that this interface is meant to be available for CDI injection as a REST Client
 * */

@RegisterRestClient(baseUri = "https://viacep.com.br/ws")
@Produces(MediaType.APPLICATION_JSON)
public interface ViaCepClient {

    @GET
    @Path("/{zipCode}/json")
    AddressResponse getAddressByZipCode(@PathParam("zipCode") String zipCode);
}
