package br.com.joaogabriel.payload.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.json.bind.annotation.JsonbProperty;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ExampleMapperResponse(
        @JsonbProperty("Information")
        String value
) implements Serializable {
}