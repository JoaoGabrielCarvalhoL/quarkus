package br.com.joaogabriel.payload.request;

import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

public record ExampleMapperRequest(
        @NotBlank(message = "The field cannot be empty!")
        String value
) implements Serializable {
}
