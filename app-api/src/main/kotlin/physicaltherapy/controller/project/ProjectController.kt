package physicaltherapy.controller.project

import org.springframework.web.bind.annotation.RestController
import physicaltherapy.project.ProjectService

@RestController
class ProjectController(
    private val projectService: ProjectService
) {
}