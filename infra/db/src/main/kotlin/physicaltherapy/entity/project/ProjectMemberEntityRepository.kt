package physicaltherapy.entity.project

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.stereotype.Repository
import physicaltherapy.project.ProjectMember
import physicaltherapy.project.ProjectMemberRepository

@Repository
internal class ProjectMemberEntityRepository(
    private val projectMemberJpaRepository: ProjectMemberJpaRepository,
    private val projectJpaRepository: ProjectJpaRepository
): ProjectMemberRepository {

    override fun save(projectMember: ProjectMember): ProjectMember {
        val entity = projectMemberJpaRepository.save(parseDomainToEntity(projectMember))
        return parseEntityToDomain(entity)
    }

    // TODO : 도메인 객체 -> Entity 변환 시, 연관관계를 맺는 Entity 객체를 어떻게 할 것인지? (특히 저장할 때!)
    private fun parseDomainToEntity(projectMember: ProjectMember): ProjectMemberEntity {
        val projectEntity = projectJpaRepository.findById(projectMember.projectId).orElseThrow { NotFoundException() }
        return ProjectMemberEntity(
            projectEntity,
            projectMember.userId,
        )
    }

    private fun parseEntityToDomain(entity: ProjectMemberEntity): ProjectMember {
        return ProjectMember(
            entity.projectEntity.id,
            entity.userId,
        )
    }
}
