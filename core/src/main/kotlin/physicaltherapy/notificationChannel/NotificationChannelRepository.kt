package physicaltherapy.notificationChannel

interface NotificationChannelRepository {
    fun save(notificationChannel: NotificationChannel): NotificationChannel

    fun findByProjectId(projectId: Long): NotificationChannel?
}
