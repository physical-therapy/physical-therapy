package physicaltherapy.project

import org.springframework.stereotype.Component

@Component
class ProjectReader(
    private val projectRepository: ProjectRepository
) {
}