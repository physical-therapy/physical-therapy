package physicaltherapy.project.controller.dto

import java.time.LocalDateTime

data class CreateProjectRequest(
    val name: String,
    val description: String,
    val recruitmentEndDate: LocalDateTime,
    val master: String,
    val cycle: Int,
    val startDate: LocalDateTime,
    val endDate: LocalDateTime,
) {
}