package physicaltherapy.entity.project

import org.springframework.stereotype.Repository
import physicaltherapy.project.Project
import physicaltherapy.project.ProjectRepository

@Repository
internal class ProjectEntityRepository(
    private val projectJpaRepository: ProjectJpaRepository,
    private val projectMapper: ProjectMapper,
): ProjectRepository {
    override fun save(project:
                      Project): Project {
        val entity = projectJpaRepository.save(projectMapper.toEntity(project))
        return projectMapper.toDto(entity)
    }
}
