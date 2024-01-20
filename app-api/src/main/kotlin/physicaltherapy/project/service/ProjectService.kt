package physicaltherapy.project.service

import org.springframework.stereotype.Service
import physicaltherapy.external.service.SlackService
import physicaltherapy.notificationChannel.NotificationChannel
import physicaltherapy.notificationChannel.NotificationChannelWriter
import physicaltherapy.project.controller.dto.CreateProjectRequest
import physicaltherapy.project.ProjectReader
import physicaltherapy.project.ProjectWriter

@Service
class ProjectService(
    private val projectReader: ProjectReader,
    private val projectWriter: ProjectWriter,
    private val notificationChannelWriter: NotificationChannelWriter,
    private val slackService: SlackService,
) {

    // TODO:추후 스케줄러에서 스터디 모집 실패 시 채널 삭제하라고 관리자에게 알림 메시지 발송  (+ 스터디 종료 때)
    fun create(request: CreateProjectRequest) {
        // 1. 스터디 생성 요청 (req: 메시지 전송 채널, 스터디 이름 & 소개, 스터디 시작일/종료일, 모집마감기한, 스터디장, 스터디 주기)

        // CreateProjectRequest -> Project
        val project = projectWriter.create(request.toProject())
        val notificationChannel = NotificationChannel(request.channelName, project.id)

        // 2. NotificationChannel 생성

        // 2-1. 같은 이름의 채널이 존재하는지 확인
        if (slackService.isExistChannel(request.channelName)) {
            throw IllegalStateException("이미 존재하는 채널입니다. channelName: ${request.channelName}")
        }

        // slack channel 생성
        slackService.createChannel(notificationChannel.channelName)

        notificationChannelWriter.create(notificationChannel)

        // 3. Project 생성
        // 3-1. Validation
        // 3-2. 스터디장 존재 확인 후 없으면 생성(ProjectMember, User)
        // 3-3. Project 생성 & NotificationChannel 생성
    }
}
