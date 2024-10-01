package br.com.joaogabriel.pattern.active.record;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.persistence.*;

import java.util.UUID;

/**
 * PanacheEntity: Long id.
 * PanacheEntityBase: Without id.
 *
 * */

@Entity
@Table(name = "table_active_record_pattern_entity")
public class ActiveRecordPatternEntity extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String pattern;

    private String firstAttribute;

    private String secondAttribute;

    public ActiveRecordPatternEntity() {}


    public ActiveRecordPatternEntity(String pattern, String firstAttribute, String secondAttribute) {
        this.pattern = pattern;
        this.firstAttribute = firstAttribute;
        this.secondAttribute = secondAttribute;
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

    public String getFirstAttribute() {
        return firstAttribute;
    }

    public void setFirstAttribute(String firstAttribute) {
        this.firstAttribute = firstAttribute;
    }

    public String getSecondAttribute() {
        return secondAttribute;
    }

    public void setSecondAttribute(String secondAttribute) {
        this.secondAttribute = secondAttribute;
    }
}
