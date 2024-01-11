package physicaltherapy.entity.notificationChannel

import org.springframework.stereotype.Repository
import physicaltherapy.notificationChannel.NotificationChannel
import physicaltherapy.notificationChannel.NotificationChannelRepository

@Repository
internal class NotificationChannelEntityRepository(
    private val notificationChannelJpaRepository: NotificationChannelJpaRepository
) : NotificationChannelRepository {
    override fun save(notificationChannel: NotificationChannel): NotificationChannel {
        val entity = notificationChannelJpaRepository.save(parseDomainToEntity(notificationChannel))

        return parseEntityToDomain(entity)
    }

    private fun parseDomainToEntity(notificationChannel: NotificationChannel): NotificationChannelEntity {
        return NotificationChannelEntity(
            notificationChannel.channelName,
            notificationChannel.projectId,
        )
    }

    private fun parseEntityToDomain(notificationChannelEntity: NotificationChannelEntity): NotificationChannel {
        return NotificationChannel(
            notificationChannelEntity.channelName,
            notificationChannelEntity.projectId,
        )
    }
}
