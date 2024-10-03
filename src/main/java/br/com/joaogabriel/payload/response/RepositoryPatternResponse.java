package br.com.joaogabriel.payload.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record RepositoryPatternResponse(
        UUID id,
        String pattern
) implements Serializable {
}
