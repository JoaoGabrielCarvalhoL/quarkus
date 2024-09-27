package br.com.joaogabriel.mapper;

import br.com.joaogabriel.entity.ExampleMapperEntity;
import br.com.joaogabriel.payload.request.ExampleMapperRequest;
import br.com.joaogabriel.payload.response.ExampleMapperResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.CDI,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ExampleMapper {

    @Mapping(source = "value", target = "someValue")
    ExampleMapperEntity toExampleMapperEntity(ExampleMapperRequest exampleMapperRequest);

    @Mapping(source = "someValue", target = "value")
    ExampleMapperResponse toExampleMapperResponse(ExampleMapperEntity exampleMapperEntity);
}
