package br.com.joaogabriel.pattern.active.record;

import io.quarkus.panache.mock.PanacheMock;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@QuarkusTest
public class ActiveRecordPatternTest {

    @Test
    public void findAllByIdTest() {
        PanacheMock.mock(ActiveRecordPatternEntity.class);
        Mockito.when(ActiveRecordPatternEntity.findById(Mockito.any()))
                .thenReturn(new ActiveRecordPatternEntity("Active Record Pattern", "Active", "Record"));
        ActiveRecordPatternEntity all = ActiveRecordPatternEntity.findById(UUID.randomUUID());
        Assertions.assertNotNull(all);
        Assertions.assertEquals("Active Record Pattern",
                all.getPattern());
    }

    @Test
    public void findAllByPatternTest() {
        PanacheMock.mock(ActiveRecordPatternEntity.class);
        Mockito.when(ActiveRecordPatternEntity.list(Mockito.anyString(), Optional.ofNullable(Mockito.any())))
                .thenReturn(List.of(new ActiveRecordPatternEntity("Active Record Pattern", "Active", "Record")));
        List<ActiveRecordPatternEntity> all = ActiveRecordPatternEntity.list("Active Record Pattern");
        Assertions.assertNotNull(all);
        Assertions.assertEquals("Active Record Pattern",
                all.getFirst().getPattern());
    }


}
