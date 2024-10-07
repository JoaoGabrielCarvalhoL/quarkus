package br.com.joaogabriel.resource;

import br.com.joaogabriel.payload.request.RepositoryPatternRequest;
import br.com.joaogabriel.payload.response.RepositoryPatternResponse;
import br.com.joaogabriel.service.RepositoryPatternService;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.util.UUID;

@Path("/api/v1/repository")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RepositoryPatternResource {

    private final RepositoryPatternService repositoryPatternService;

    public RepositoryPatternResource(RepositoryPatternService repositoryPatternService) {
        this.repositoryPatternService = repositoryPatternService;
    }

    /**
     * Hateoas. How to implement on quarkus?
     * In Spring, we can extend RepresentationModel or use EntityModel<> and add links.
     * Add Link into object response? ...
     * */

    @POST
    public Response save(@Valid RepositoryPatternRequest repositoryPatternRequest, @Context UriInfo uriInfo) {
        RepositoryPatternResponse saved = this.repositoryPatternService.save(repositoryPatternRequest);
        UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
        Link link = Link.fromUri(uriBuilder.path(saved.id().toString()).build()).rel("self").build();

        /**
         * Creating a Header Location and Link. Ambiguous maybe
         * https://dennis-xlc.gitbooks.io/restful-java-with-jax-rs-2-0-2rd-edition/content/en/part1/chapter10/building_links_and_link_headers.html
         * */

        return Response.created(uriBuilder.build()).
                entity(saved)
                .links(link)
                .build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") UUID id) {
        RepositoryPatternResponse entity = this.repositoryPatternService.findById(id);
        return Response.ok().entity(entity).build();
    }

}
