package physicaltherapy.project

interface ProjectMemberRepository {
    fun save(project: ProjectMember): ProjectMember
    fun saveAll(projectMembers: List<ProjectMember>)
}
