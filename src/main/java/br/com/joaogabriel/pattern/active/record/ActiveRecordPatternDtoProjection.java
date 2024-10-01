package br.com.joaogabriel.pattern.active.record;

import io.quarkus.runtime.annotations.RegisterForReflection;

import java.util.UUID;

/**
 * The @RegisterForReflection annotation instructs Quarkus to keep the class and its members during the native compilation
 * */
@RegisterForReflection
public class ActiveRecordPatternDtoProjection {
    private UUID id;
    private String pattern;

    /**
     * The projection class needs to have a constructor that contains all its attributes,
     * this constructor will be used to instantiate the projection DTO instead of using the entity class.
     *
     * Hibernate will use this constructor,
     * it must be the only constructor in your class and have all the class attributes as parameters.
     * */
    public ActiveRecordPatternDtoProjection(UUID id, String pattern) {
        this.id = id;
        this.pattern = pattern;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }
}
