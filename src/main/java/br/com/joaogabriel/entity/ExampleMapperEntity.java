package br.com.joaogabriel.entity;

import java.time.LocalDate;
import java.util.UUID;

public class ExampleMapperEntity {

    private UUID id;
    private String someValue;
    private LocalDate occurrenceIn;

    public ExampleMapperEntity() {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getSomeValue() {
        return someValue;
    }

    public void setSomeValue(String someValue) {
        this.someValue = someValue;
    }

    public LocalDate getOccurrenceIn() {
        return occurrenceIn;
    }

    public void setOccurrenceIn(LocalDate occurrenceIn) {
        this.occurrenceIn = occurrenceIn;
    }
}
