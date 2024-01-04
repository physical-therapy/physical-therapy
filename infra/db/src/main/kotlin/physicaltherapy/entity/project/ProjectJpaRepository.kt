package physicaltherapy.entity.project

import org.springframework.data.jpa.repository.JpaRepository

internal interface ProjectJpaRepository: JpaRepository<ProjectEntity, Long>