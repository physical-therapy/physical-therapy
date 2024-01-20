package physicaltherapy.entity.project

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import jakarta.persistence.UniqueConstraint
import physicaltherapy.entity.BaseEntity

@Table(
        name = "project_member",
        uniqueConstraints = [
                UniqueConstraint(name = "uk_user_id_project_id", columnNames = ["user_id", "project_id"])
        ]
)
@Entity
internal class ProjectMemberEntity(
        @JoinColumn(name = "project_id", nullable = false)
        @ManyToOne(fetch = FetchType.LAZY)
        val projectEntity: ProjectEntity,

        @Column(name = "user_id", nullable = false)
        val userId: String,
): BaseEntity()
