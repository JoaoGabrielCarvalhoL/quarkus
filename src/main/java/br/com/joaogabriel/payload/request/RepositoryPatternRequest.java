package br.com.joaogabriel.payload.request;

import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

public record RepositoryPatternRequest(
        @NotBlank
        String pattern,
        String firstAttribute,
        String secondAttribute
) implements Serializable {
}
