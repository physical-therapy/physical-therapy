package physicaltherapy.entity.notificationChannel

import org.springframework.data.jpa.repository.JpaRepository

internal interface NotificationChannelJpaRepository : JpaRepository<NotificationChannelEntity, Long> {
    fun findByProjectId(projectId: Long): NotificationChannelEntity?
}
