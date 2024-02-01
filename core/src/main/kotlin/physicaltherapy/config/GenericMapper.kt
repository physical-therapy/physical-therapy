package physicaltherapy.config

import org.mapstruct.IterableMapping
import org.mapstruct.Named

interface GenericMapper<E, D> {
    @Named("toDto")
    fun toDto(entity: E): D

    @Named("toEntity")
    fun toEntity(dto: D): E

    @IterableMapping(qualifiedByName = ["toDto"])
    fun toDtos(entities: List<E>): List<D>
}
