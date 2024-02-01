package physicaltherapy.entity.project

import org.mapstruct.Mapper
import physicaltherapy.config.BaseMapperConfig
import physicaltherapy.config.GenericMapper
import physicaltherapy.project.Project

@Mapper(config = BaseMapperConfig::class)
internal interface ProjectMapper : GenericMapper<ProjectEntity, Project> {

}
