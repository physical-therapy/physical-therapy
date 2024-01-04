package physicaltherapy.project

import java.time.LocalDateTime

data class Project(
    private val name: String,
    private val description: String,
    private val recruitmentEndDate: LocalDateTime,
    private val master: String,
    private val cycle: Int,
    private val startDate: LocalDateTime,
    private val endDate: LocalDateTime,
) {
}