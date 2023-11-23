package physicaltherapy.entity.sprint

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import physicaltherapy.entity.BaseEntity
import physicaltherapy.entity.project.ProjectEntity
import java.time.LocalDateTime

@Entity
internal class SprintEntity(
        @JoinColumn(name = "project_id", nullable = false)
        @ManyToOne(fetch = FetchType.LAZY)
        val projectEntity: ProjectEntity,

        @Column(name = "round", nullable = false)
        val round: Int,

        @Column(name = "cycle", nullable = false)
        val cycle: Int,

        @Column(name = "start_date", nullable = false)
        val startDate: LocalDateTime,

        @Column(name = "end_date", nullable = false)
        val endDate: LocalDateTime,
): BaseEntity() {
}