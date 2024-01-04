package physicaltherapy.project.controller

import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import physicaltherapy.project.service.ProjectService
import physicaltherapy.project.controller.dto.CreateProjectRequest

@RestController
class ProjectController(
    private val projectService: ProjectService
) {

    @PostMapping("/projects")
    fun create(
        @Valid @RequestBody request: CreateProjectRequest
    ) {
        projectService.create(request)
    }
}