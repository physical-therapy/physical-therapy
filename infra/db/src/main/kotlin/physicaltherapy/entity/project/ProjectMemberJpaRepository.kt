package physicaltherapy.entity.project

import org.springframework.data.jpa.repository.JpaRepository

internal interface ProjectMemberJpaRepository: JpaRepository<ProjectMemberEntity, Long> {
}
