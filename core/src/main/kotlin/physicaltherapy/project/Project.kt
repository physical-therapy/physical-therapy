package physicaltherapy.project

import java.time.LocalDate
import java.time.LocalDateTime

data class Project(
    val name: String,
    val description: String,
    val recruitmentEndDate: LocalDateTime,
    val master: String,
    val cycle: Int,
    val projectStatus: ProjectStatus,
    val startDate: LocalDate,
    val endDate: LocalDate,
    val id: Long = 0L,
) {

    init {
        require(startDate < endDate) { "스타디 시작 시점이 종료 시점보다 늦을 수 없습니다." }
        require(recruitmentEndDate.toLocalDate() < startDate) { "스터디 모집일이 시작일보다 늦을 수 없습니다." }
        require(master.isNotBlank()) { "스터디장은 필수입니다." }
        require(cycle > 0) { "스터디 주기는 1일 이상이어야 합니다." }
        require(name.isNotBlank()) { "스터디 이름은 필수입니다." }
    }
}
