package br.com.joaogabriel.pattern.repository;

import br.com.joaogabriel.pattern.repository.projection.RepositoryPatternDtoProjection;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

//https://quarkus.io/guides/hibernate-orm-panache#using-the-repository-pattern

@ApplicationScoped
public class RepositoryPattern implements PanacheRepositoryBase<RepositoryPatternEntity, UUID> {

    List<RepositoryPatternEntity> findAllByPattern(String pattern) {
       return list("pattern", pattern);
    }

    public Optional<RepositoryPatternEntity> findByFirstAttribute(String firstAttribute) {
        return find("firstAttribute", firstAttribute).stream().findFirst();
    }

    public List<RepositoryPatternEntity> findAllPagination() {
        PanacheQuery<RepositoryPatternEntity> all = findAll(Sort.ascending("pattern"));
        return all.page(0, 10).list();
    }

    public List<RepositoryPatternDtoProjection> projection(String pattern) {
        return find("pattern", pattern).project(RepositoryPatternDtoProjection.class).list();
    }
}
