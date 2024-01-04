package physicaltherapy.entity.project

import jakarta.persistence.Column
import jakarta.persistence.Entity
import physicaltherapy.entity.BaseEntity
import java.time.LocalDate
import java.time.LocalDateTime

private val DEFAULT_END_DATE: LocalDate = LocalDate.of(2999, 12, 31)

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
        val startDate: LocalDate,

        @Column(name = "end_date", nullable = false)
        val endDate: LocalDate = DEFAULT_END_DATE,
): BaseEntity()