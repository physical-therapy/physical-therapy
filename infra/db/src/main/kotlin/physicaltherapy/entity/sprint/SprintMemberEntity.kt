package physicaltherapy.entity.sprint

import jakarta.persistence.*
import physicaltherapy.entity.BaseEntity

@Entity
internal class SprintMemberEntity(
        @JoinColumn(name = "sprint_id", nullable = false)
        @ManyToOne(fetch = FetchType.LAZY)
        val sprintEntity: SprintEntity,

        @Column(name = "user_id", nullable = false)
        val userId: String,
): BaseEntity()