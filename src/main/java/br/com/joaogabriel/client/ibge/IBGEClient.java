package br.com.joaogabriel.client.ibge;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "https://servicodados.ibge.gov.br/api/v1/localidades/estados")
@Produces(MediaType.APPLICATION_JSON)
public interface IBGEClient {

    @GET
    @Path("/{uf}/distritos")
    Object getDistrictByUf(@PathParam("uf") String uf);
}
