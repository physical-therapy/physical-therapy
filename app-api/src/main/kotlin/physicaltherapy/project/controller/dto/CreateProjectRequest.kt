package physicaltherapy.project.controller.dto

import jakarta.validation.constraints.Future
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import physicaltherapy.project.Project
import java.time.LocalDate
import java.time.LocalDateTime

data class CreateProjectRequest(
    @field:NotBlank(message = "스터디 이름은 필수입니다.")
    val name: String,
    @field:NotBlank(message = "스터디 소개는 필수입니다.")
    val description: String,
    @field:Future(message = "모집 마감일은 현재 시간 이후여야 합니다.")
    val recruitmentEndDate: LocalDateTime,
    @field:NotBlank(message = "스터디장은 필수입니다.")
    val master: String,
    @field:Min(value = 1, message = "스터디 주기는 1 이상이어야 합니다.")
    val cycle: Int,
    @field:Future(message = "스터디 시작일은 현재 시간 이후여야 합니다.")
    val startDate: LocalDate,
    @field:Future(message = "스터디 종료일은 현재 시간 이후여야 합니다.")
    val endDate: LocalDate,
    @field:NotBlank(message = "스터디장은 필수입니다.")
    val channelName: String,
) {

    fun toProject(): Project {
        return Project(
            name = name,
            description = description,
            recruitmentEndDate = recruitmentEndDate,
            master = master,
            cycle = cycle,
            startDate = startDate,
            endDate = endDate,
        )
    }
}
