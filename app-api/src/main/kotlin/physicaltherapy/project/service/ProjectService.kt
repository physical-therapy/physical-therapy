package physicaltherapy.project.service

import org.springframework.stereotype.Service
import physicaltherapy.project.controller.dto.CreateProjectRequest
import physicaltherapy.project.ProjectReader
import physicaltherapy.project.ProjectWriter

@Service
class ProjectService(
    private val projectReader: ProjectReader,
    private val projectWriter: ProjectWriter
) {

    fun create(request: CreateProjectRequest) {
        // 1. 스터디 생성 요청 (req: 메시지 전송 채널, 스터디 이름 & 소개, 스터디 시작일/종료일, 모집마감기한, 스터디장, 스터디 주기)

        // 2. NotificationChannel 생성
        // 2-1. 같은 이름의 채널이 존재하는지 확인
        // 2-2. 없으면 Validation
        // 2-4 스터디 모집 실패시 채널 X  (가능하다면)

        // 3. Project 생성
        // 3-1. Validation
        // 3-2. 스터디장 존재 확인 후 없으면 생성(ProjectMember, User)
        // 3-3. Project 생성 & NotificationChannel 생성
    }
}