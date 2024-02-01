package physicaltherapy.project.service

import org.springframework.beans.factory.annotation.Value
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import physicaltherapy.external.service.SlackService
import physicaltherapy.notificationChannel.NotificationChannel
import physicaltherapy.notificationChannel.NotificationChannelWriter
import physicaltherapy.project.ProjectMember
import physicaltherapy.project.ProjectMemberWriter
import physicaltherapy.project.controller.dto.CreateProjectRequest
import physicaltherapy.project.ProjectReader
import physicaltherapy.project.ProjectWriter

@Service
class ProjectService(
    private val projectReader: ProjectReader,
    private val projectWriter: ProjectWriter,
    private val notificationChannelWriter: NotificationChannelWriter,
    private val slackService: SlackService,
    private val projectMemberWriter: ProjectMemberWriter,

    @Value("\${slack-api.notify-channel-id}")
    private val notifyChannelId: String,
) {

    // TODO: 추후 스케줄러에서 스터디 모집 실패 시 채널 삭제하라고 관리자에게 알림 메시지 발송  (+ 스터디 종료 때)
    fun create(request: CreateProjectRequest) {
        val project = projectWriter.create(request.toProject())
        projectMemberWriter.create(ProjectMember(projectId = project.id, userId = request.master))
        val notificationChannel = NotificationChannel(request.channelName, project.id)

        // 같은 이름의 슬랙 채널이 존재하는지 확인
        if (slackService.isExistChannel(request.channelName)) {
            throw IllegalStateException("이미 존재하는 채널입니다. channelName: ${request.channelName}")
        }

        // slack channel 생성 (slack 채널 생성불가한 경우 스터디 생성 불가)
        slackService.createChannel(notificationChannel.channelName)
        notificationChannelWriter.create(notificationChannel)

        /**
         * [AS IS] MVP로 단순 텍스트만 발송하고있으나
         * [TO BE] MarkDown 형식 or 블록 형식 등 이용해서 조금 더 템플릿 스럽게 만들어보기!
         *
         * slackApiClient#scheduleMessage --> 슬랙 예약 발송 기능 활용 방안성 고민해보기
         */
        // 최소 단위)  1. 스터디 제목, 2. 스터디 목표, 3.스터디 내용 (글자 제한...?), --> [선행조건] 스터디 모집글 템플릿 선정
        slackService.sendMessage(notifyChannelId, "${request.name} 스터디 스터디원을 모집합니다.")
    }

    /**
     * 모집 완료 (확정) <<
     *  Scheduler 통해서 채널 public 전환 (채널명 unique하게 할 방법 고민)
     *  참가자 채널로 초대
     */
    @Scheduled(cron = "0 0 0 * * *") // TODO: 크론식은 좀이따 바꿀 예정
    fun closeRecruitment() {
//        val projects = projectReader.
    }

}
