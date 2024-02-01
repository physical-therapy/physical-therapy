package physicaltherapy.project.service

import org.junit.jupiter.api.*
import org.mockito.BDDMockito.*
import org.mockito.Mock
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import physicaltherapy.external.service.SlackService
import physicaltherapy.notificationChannel.NotificationChannelWriter
import physicaltherapy.notificationChannel.NotificationChannerReader
import physicaltherapy.project.ProjectMemberWriter
import physicaltherapy.project.ProjectReader
import physicaltherapy.project.ProjectWriter
import physicaltherapy.project.controller.dto.CreateProjectRequest
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

@SpringBootTest
class ProjectServiceTest {
    @Autowired
    private lateinit var projectReader: ProjectReader

    @Autowired
    private lateinit var projectWriter: ProjectWriter

    @Autowired
    private lateinit var notificationChannelReader: NotificationChannerReader

    @Autowired
    private lateinit var notificationChannelWriter: NotificationChannelWriter

    @Mock
    private lateinit var slackService: SlackService

    @Autowired
    private lateinit var projectMemberWriter: ProjectMemberWriter

    private lateinit var sut: ProjectService

    @BeforeEach
    fun setUp() {
        this.sut =
            ProjectService(
                projectReader,
                projectWriter,
                notificationChannelReader,
                notificationChannelWriter,
                slackService,
                projectMemberWriter,
                "test-notify-channel-id",
            )
    }

    @DisplayName("프로젝트 생성")
    @Test
    fun `testInit`() {
        // given
        val request =
            CreateProjectRequest(
                "test-name",
                "test-description",
                LocalDateTime.of(LocalDate.of(2024, 1, 21), LocalTime.MIN),
                "master",
                7,
                LocalDate.of(2024, 1, 22),
                LocalDate.of(2099, 1, 22),
                "test-channel-name",
            )

        // when // then
        assertDoesNotThrow { sut.create(request) }
    }

    @DisplayName("프로젝트 생성 실패 - 슬랙 채널이 이미 존재하는 경우")
    @Test
    fun testInitIfSlackChannelIsExist() {
        // given
        val request =
            CreateProjectRequest(
                "test-name",
                "test-description",
                LocalDateTime.of(LocalDate.of(2024, 1, 21), LocalTime.MIN),
                "master",
                7,
                LocalDate.of(2024, 1, 22),
                LocalDate.of(2099, 1, 22),
                "test-channel-name",
            )

        // when
        given(slackService.isExistChannel(anyString())).willReturn(true)

        // then
        assertThrows<IllegalStateException> { sut.create(request) }
    }

    @DisplayName("프로젝트 생성 시, 슬랙 채널 생성에 실패하면 예외를 발생한다")
    @Test
    fun testInitIfCreateSlackChannelIsFail() {
        // given
        val channelName = "test-channel-name"
        val request =
            CreateProjectRequest(
                "test-name",
                "test-description",
                LocalDateTime.of(LocalDate.of(2024, 1, 21), LocalTime.MIN),
                "master",
                7,
                LocalDate.of(2024, 1, 22),
                LocalDate.of(2099, 1, 22),
                channelName,
            )

        given(slackService.isExistChannel(channelName)).willReturn(false)
        given(slackService.createChannel(channelName)).willThrow(RuntimeException::class.java)

        // when // then
        assertThrows<RuntimeException> { sut.create(request) }
    }

    @DisplayName("프로젝트 생성 완료 후, 스터디 모집 슬랙 메시지 발송에 실패하면 예외가 발생한다")
    @Test
    fun testInitIfSendSlackMessageAfterProjectCreation() {
        // given
        val channelName = "test-channel-name"
        val request =
            CreateProjectRequest(
                "test-name",
                "test-description",
                LocalDateTime.of(LocalDate.of(2024, 1, 21), LocalTime.MIN),
                "master",
                7,
                LocalDate.of(2024, 1, 22),
                LocalDate.of(2099, 1, 22),
                channelName,
            )
        val notifyChannelId = "test-notify-channel-id"

        given(slackService.isExistChannel(channelName)).willReturn(false)
        doNothing().`when`(slackService).createChannel(channelName)
        given(slackService.sendMessage(notifyChannelId, "${request.name} 스터디 스터디원을 모집합니다.")).willThrow(RuntimeException::class.java)

        // when / then
        assertThrows<RuntimeException> { sut.create(request) }
    }
}
