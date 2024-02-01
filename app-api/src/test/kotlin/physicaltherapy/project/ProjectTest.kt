package physicaltherapy.project

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.ValueSource
import java.time.LocalDate
import java.time.LocalDateTime

class ProjectTest {
    @DisplayName("프로젝트 객체 생성 시, 프로젝트 이름이 비어있으면 예외를 발생시킨다")
    @ParameterizedTest
    @ValueSource(strings = [" ", "               "])
    @EmptySource
    fun testInitIfWhenNameIsBlank(name: String) {
        // given
        val now = LocalDateTime.now()

        // when // then
        assertThrows<IllegalArgumentException> {
            Project(
                name = name,
                description = "test Description",
                recruitmentEndDate = now.plusDays(3),
                master = "testMaster",
                cycle = 3,
                projectStatus = ProjectStatus.RECRUITING,
                startDate = now.plusDays(4).toLocalDate(),
                endDate = now.plusDays(5).toLocalDate(),
                threadTs = "",
                id = 1L,
            )
        }
    }

    @DisplayName("프로젝트 객체 생성 시, 스터디 장 이름이 비어있으면 예외를 발생시킨다")
    @ParameterizedTest
    @ValueSource(strings = [" ", "               "])
    @EmptySource
    fun testInitIfWhenMasterIsBlank(master: String) {
        // given
        val now = LocalDateTime.now()

        // when // then
        assertThrows<IllegalArgumentException> {
            Project(
                name = "king_loki",
                description = "test Description",
                recruitmentEndDate = now.plusDays(3),
                projectStatus = ProjectStatus.RECRUITING,
                master = master,
                cycle = 3,
                startDate = now.plusDays(4).toLocalDate(),
                endDate = now.plusDays(5).toLocalDate(),
                threadTs = "",
                id = 1L,
            )
        }
    }

    @DisplayName("프로젝트 객체 생성 시, 스터디 주기는 1일 미만이면 예외를 발생시킨다")
    @Test
    fun testInitIfWhenCycleIsLessThanOne() {
        // given
        val now = LocalDate.now()
        val startDate = now.plusDays(2)
        val endDate = now.plusDays(1)

        // when // then
        assertThrows<IllegalArgumentException> {
            Project(
                name = "king_habin",
                description = "test Description",
                recruitmentEndDate = LocalDateTime.now(),
                projectStatus = ProjectStatus.RECRUITING,
                master = "testMaster",
                cycle = 0,
                startDate = startDate,
                endDate = endDate,
                threadTs = "",
                id = 1L,
            )
        }
    }

    @DisplayName("프로젝트 객체 생성 시, 스터디 종료일자가 시작일자보다 이전이면 예외를 발생시킨다")
    @Test
    fun testInitIfWhenEndDateIsBeforeStartDate() {
        // given
        val now = LocalDate.now()
        val startDate = now.plusDays(2)
        val endDate = now.plusDays(1)

        // when // then
        assertThrows<IllegalArgumentException> {
            Project(
                name = "king_bono",
                description = "test Description",
                recruitmentEndDate = LocalDateTime.now(),
                projectStatus = ProjectStatus.RECRUITING,
                master = "testMaster",
                cycle = 3,
                startDate = startDate,
                endDate = endDate,
                threadTs = "",
                id = 1L,
            )
        }
    }

    @DisplayName("프로젝트 객체 생성 시, 스터디 모집일이 시작일보다 늦으면 예외를 발생시킨다")
    @Test
    fun testInitIfWhenRecruitmentEndDateIsAfterStartDate() {
        // given
        val now = LocalDateTime.now()
        val recruitmentEndDate = now.plusDays(2)
        val startDate = now.plusDays(1).toLocalDate()

        // when // then
        assertThrows<IllegalArgumentException> {
            Project(
                name = "king_bono",
                description = "test Description",
                recruitmentEndDate = recruitmentEndDate,
                projectStatus = ProjectStatus.RECRUITING,
                master = "testMaster",
                cycle = 3,
                startDate = startDate,
                endDate = startDate.plusDays(2),
                threadTs = "",
                id = 1L,
            )
        }
    }
}
