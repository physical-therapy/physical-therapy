package physicaltherapy.entity.project

import jakarta.persistence.Column
import jakarta.persistence.Entity
import physicaltherapy.entity.BaseEntity
import java.time.LocalDateTime

private val DEFAULT_END_DATE: LocalDateTime = LocalDateTime.of(2999, 12, 31, 23,59,59)

@Entity
internal class ProjectEntity(
        @Column(name = "name", nullable = false)
        val name: String,

        @Column(name = "description", nullable = false)
        val description: String,

        @Column(name = "recruitment_end_date", nullable = false)
        val recruitmentEndDate: LocalDateTime,

        @Column(name = "master", nullable = false)
        val master: String,

        @Column(name = "cycle", nullable = false)
        var cycle: Int,

        @Column(name = "start_date", nullable = false)
        val startDate: LocalDateTime,

        @Column(name = "end_date", nullable = false)
        val endDate: LocalDateTime = DEFAULT_END_DATE,
): BaseEntity()