package physicaltherapy.project

import org.springframework.stereotype.Component

@Component
class ProjectMemberWriter(
    private val projectMemberRepository: ProjectMemberRepository
) {

    fun create(projectMember: ProjectMember): ProjectMember {
        return projectMemberRepository.save(projectMember)
    }

    fun createAll(projectMembers: List<ProjectMember>) {
        projectMemberRepository.saveAll(projectMembers)
    }
}
