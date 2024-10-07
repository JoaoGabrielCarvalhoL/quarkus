package br.com.joaogabriel.exception.response;

import jakarta.json.bind.annotation.JsonbPropertyOrder;

import java.io.Serializable;
import java.time.LocalDateTime;

@JsonbPropertyOrder({ "title", "status", "message", "timestamp" })
public record ExceptionResponse(String title,
                                String message,
                                Integer status,
                                LocalDateTime timestamp)
        implements Serializable {
}
