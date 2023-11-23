package physicaltherapy.entity.project

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import physicaltherapy.entity.BaseEntity

@Entity
internal class ProjectMemberEntity(
        @JoinColumn(name = "project_id", nullable = false)
        @ManyToOne(fetch = FetchType.LAZY)
        val projectEntity: ProjectEntity,

        @Column(name = "user_id", nullable = false)
        val userId: String,
): BaseEntity()
