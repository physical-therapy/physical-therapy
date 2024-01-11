package physicaltherapy.notificationChannel

import org.springframework.stereotype.Component

@Component
class NotificationChannelWriter(
    private val notificationChannelRepository: NotificationChannelRepository
) {

    fun create(notificationChannel: NotificationChannel): NotificationChannel {
        return notificationChannelRepository.save(notificationChannel)
    }

}
