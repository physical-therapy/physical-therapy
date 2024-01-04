package physicaltherapy.project

import org.springframework.stereotype.Component

@Component
class ProjectWriter(
    private val projectRepository: ProjectRepository
) {
}