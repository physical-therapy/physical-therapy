package physicaltherapy.project.controller.dto

import jakarta.validation.constraints.Future
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import java.time.LocalDate
import java.time.LocalDateTime

data class CreateProjectRequest(
    @field:NotBlank
    val name: String,
    @field:NotBlank
    val description: String,
    @field:Future
    val recruitmentEndDate: LocalDateTime,
    @field:NotBlank
    val master: String,
    @field:Min(value = 1)
    val cycle: Int,
    @field:Future
    val startDate: LocalDate,
    @field:Future
    val endDate: LocalDate,
) {
}