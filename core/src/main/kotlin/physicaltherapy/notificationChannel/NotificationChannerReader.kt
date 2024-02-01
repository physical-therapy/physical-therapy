package physicaltherapy.notificationChannel

import org.springframework.stereotype.Component

@Component
class NotificationChannerReader(
    private val notificationChannelRepository: NotificationChannelRepository,
) {
    fun findByProjectId(projectId: Long): NotificationChannel {
        return notificationChannelRepository.findByProjectId(projectId) ?: throw NoSuchElementException("존재하지 않는 채널입니다. projectId: $projectId")
    }
}
