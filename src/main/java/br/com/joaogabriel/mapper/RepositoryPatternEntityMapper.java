package br.com.joaogabriel.mapper;

import br.com.joaogabriel.entity.ExampleMapperEntity;
import br.com.joaogabriel.pattern.repository.RepositoryPatternEntity;
import br.com.joaogabriel.payload.request.ExampleMapperRequest;
import br.com.joaogabriel.payload.request.RepositoryPatternRequest;
import br.com.joaogabriel.payload.response.ExampleMapperResponse;
import br.com.joaogabriel.payload.response.RepositoryPatternResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.CDI,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RepositoryPatternEntityMapper {

    RepositoryPatternEntity toRepositoryPatternEntity(RepositoryPatternRequest repositoryPatternRequest);

    RepositoryPatternResponse toRepositoryPatternResponse(RepositoryPatternEntity repositoryPatternEntity);
}
