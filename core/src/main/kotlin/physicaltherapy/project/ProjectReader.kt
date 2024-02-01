package physicaltherapy.project

import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class ProjectReader(
    private val projectRepository: ProjectRepository,
) {
    fun completeRecruitmentByDate(date: LocalDate): List<Project> {
        return projectRepository.getProjectByRecruitmentDate(date = date)
    }
}
