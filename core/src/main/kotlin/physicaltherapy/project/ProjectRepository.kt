package physicaltherapy.project

interface ProjectRepository {
    fun save(project: Project): Project
}
