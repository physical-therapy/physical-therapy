package physicaltherapy.entity.project

import org.springframework.stereotype.Repository
import physicaltherapy.project.ProjectRepository

@Repository
internal class ProjectEntityRepository(
    private val projectJpaRepository: ProjectJpaRepository
): ProjectRepository {
}