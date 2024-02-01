package physicaltherapy.entity.project

import org.mapstruct.Mapper
import org.mapstruct.MappingTarget
import physicaltherapy.config.BaseMapperConfig
import physicaltherapy.config.GenericMapper
import physicaltherapy.project.Project

@Mapper(config = BaseMapperConfig::class)
internal interface ProjectMapper : GenericMapper<ProjectEntity, Project> {
    fun updateThreadTs(
        threadTs: String,
        @MappingTarget projectEntity: ProjectEntity,
    ): ProjectEntity
}
