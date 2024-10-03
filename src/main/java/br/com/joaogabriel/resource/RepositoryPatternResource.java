package br.com.joaogabriel.resource;

import br.com.joaogabriel.payload.request.RepositoryPatternRequest;
import br.com.joaogabriel.payload.response.RepositoryPatternResponse;
import br.com.joaogabriel.service.RepositoryPatternService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.*;

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
    public Response save(RepositoryPatternRequest repositoryPatternRequest, @Context UriInfo uriInfo) {
        RepositoryPatternResponse saved = this.repositoryPatternService.save(repositoryPatternRequest);
        UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
        Link link = Link.fromUri(uriBuilder.path(saved.id().toString()).build()).rel("self").build();

        /**
         * Creating a Header Location and Link. Ambiguous maybe
         * */

        return Response.created(uriBuilder.build()).
                entity(saved)
                .links(link)
                .build();
    }

}
