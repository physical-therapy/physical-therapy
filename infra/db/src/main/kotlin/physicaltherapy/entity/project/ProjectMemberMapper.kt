package physicaltherapy.entity.project

import org.mapstruct.Mapper
import org.mapstruct.MappingTarget
import physicaltherapy.config.BaseMapperConfig
import physicaltherapy.config.GenericMapper
import physicaltherapy.project.Project
import physicaltherapy.project.ProjectMember

@Mapper(config = BaseMapperConfig::class)
internal interface ProjectMemberMapper : GenericMapper<ProjectMemberEntity, ProjectMember> {
}
