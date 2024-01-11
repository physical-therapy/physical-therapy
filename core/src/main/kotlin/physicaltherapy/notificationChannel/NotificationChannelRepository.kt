package physicaltherapy.notificationChannel

import physicaltherapy.project.Project

interface NotificationChannelRepository {
    fun save(notificationChannel: NotificationChannel): NotificationChannel
}
