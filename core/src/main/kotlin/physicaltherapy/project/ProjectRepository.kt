package physicaltherapy.project

import java.time.LocalDate

interface ProjectRepository {
    fun save(project: Project): Project

    fun getProjectByRecruitmentDate(date: LocalDate): List<Project>

    fun updateMessageChannelId(
        projectId: Long,
        threadTs: String,
    ): Project
}
