package physicaltherapy.entity.project

import org.springframework.stereotype.Repository
import physicaltherapy.project.Project
import physicaltherapy.project.ProjectRepository

@Repository
internal class ProjectEntityRepository(
    private val projectJpaRepository: ProjectJpaRepository
): ProjectRepository {
    override fun save(project: Project): Project {
        val entity = projectJpaRepository.save(parseDomainToEntity(project))
        return parseEntityToDomain(entity)
    }

    private fun parseDomainToEntity(project: Project): ProjectEntity {
        return ProjectEntity(
            project.name,
            project.description,
            project.recruitmentEndDate,
            project.master,
            project.cycle,
            project.startDate,
            project.endDate,
        )
    }

    private fun parseEntityToDomain(projectEntity: ProjectEntity): Project {
        return Project(
            projectEntity.name,
            projectEntity.description,
            projectEntity.recruitmentEndDate,
            projectEntity.master,
            projectEntity.cycle,
            projectEntity.startDate,
            projectEntity.endDate,
            projectEntity.id,
        )
    }
}
