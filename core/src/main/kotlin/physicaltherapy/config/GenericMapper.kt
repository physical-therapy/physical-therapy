package physicaltherapy.config

interface GenericMapper<E, D> {

    fun toDto(entity: E) : D

    fun toEntity(dto: D) : E

}
