package physicaltherapy.project

import org.springframework.stereotype.Component

@Component
class ProjectWriter(
    private val projectRepository: ProjectRepository
) {

    fun create(project: Project): Project {
        return projectRepository.save(project)
    }

}
