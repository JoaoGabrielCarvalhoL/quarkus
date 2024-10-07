package br.com.joaogabriel.handler;

import br.com.joaogabriel.exception.ResourceNotFoundException;
import br.com.joaogabriel.exception.response.ExceptionResponse;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.time.LocalDateTime;

/**
 *  RFC-7807
 *  https://www.rfc-editor.org/rfc/rfc7807
 * */

@Provider
public class QuarkusResourceNotFoundExceptionHandler implements ExceptionMapper<ResourceNotFoundException> {

    @Override
    public Response toResponse(ResourceNotFoundException exception) {
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(new ExceptionResponse("Bad Request", exception.getMessage(), 400, LocalDateTime.now()))
                .build();
    }
}
