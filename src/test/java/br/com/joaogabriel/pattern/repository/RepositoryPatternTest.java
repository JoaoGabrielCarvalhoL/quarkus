package br.com.joaogabriel.pattern.repository;

import br.com.joaogabriel.pattern.repository.projection.RepositoryPatternDtoProjection;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.UUID;

@QuarkusTest
public class RepositoryPatternTest {

    @InjectMock
    private RepositoryPattern repositoryPattern;

    @Test
    public void findAllByPatternTest() {
        Mockito.when(repositoryPattern.findAllByPattern(Mockito.anyString()))
                .thenReturn(List.of(new RepositoryPatternEntity("Repository Pattern", "Repository", "Pattern")));
        List<RepositoryPatternEntity> all = repositoryPattern.findAllByPattern("Repository Pattern");
        Assertions.assertNotNull(all);
        Assertions.assertEquals("Repository Pattern",
                all.getFirst().getPattern());
    }

    @Test
    public void findAllPaginationTest() {
        Mockito.when(repositoryPattern.findAllPagination())
                .thenReturn(List.of(new RepositoryPatternEntity("Repository Pattern", "Repository", "Pattern")));
        Assertions.assertNotNull(repositoryPattern.findAllPagination());
    }

    @Test
    public void projectionTest() {
        Mockito.when(repositoryPattern.projection(Mockito.anyString()))
                .thenReturn(List.of(new RepositoryPatternDtoProjection(UUID.randomUUID(), "Repository Pattern")));
        List<RepositoryPatternDtoProjection> all = repositoryPattern.projection("Repository Pattern");
        Assertions.assertNotNull(all);
        Assertions.assertEquals("Repository Pattern",
                all.getFirst().getPattern());
    }
}
