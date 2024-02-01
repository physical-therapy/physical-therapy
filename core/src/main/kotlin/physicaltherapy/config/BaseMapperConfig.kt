package physicaltherapy.config

import org.mapstruct.*

@MapperConfig(
    componentModel = MappingConstants.ComponentModel.SPRING,
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
interface BaseMapperConfig {
}
