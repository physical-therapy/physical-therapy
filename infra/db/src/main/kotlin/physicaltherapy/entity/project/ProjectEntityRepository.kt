package physicaltherapy.entity.project

import org.springframework.stereotype.Repository
import physicaltherapy.project.Project
import physicaltherapy.project.ProjectRepository
import java.time.LocalDate

@Repository
internal class ProjectEntityRepository(
    private val projectJpaRepository: ProjectJpaRepository,
    private val projectMapper: ProjectMapper,
) : ProjectRepository {
    override fun save(project: Project): Project {
        val entity = projectJpaRepository.save(projectMapper.toEntity(project))
        return projectMapper.toDto(entity)
    }

    override fun getProjectByRecruitmentDate(date: LocalDate): List<Project> {
        TODO("Not yet implemented")
    }

    override fun updateMessageChannelId(
        projectId: Long,
        threadTs: String,
    ): Project {
        val projectEntity = projectJpaRepository.findById(projectId).orElseThrow { NoSuchElementException() }
        projectMapper.updateThreadTs(threadTs, projectEntity)

        // TODO : 영속성 전파 확인 필요 (업데이트 되는지 확인해야함)
//        projectJpaRepository.save(projectEntity)
        return projectMapper.toDto(projectEntity)
    }
}
