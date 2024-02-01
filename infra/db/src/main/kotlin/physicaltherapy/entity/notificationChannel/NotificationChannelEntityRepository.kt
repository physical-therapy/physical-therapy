package physicaltherapy.entity.notificationChannel

import org.springframework.stereotype.Repository
import physicaltherapy.notificationChannel.NotificationChannel
import physicaltherapy.notificationChannel.NotificationChannelRepository

@Repository
internal class NotificationChannelEntityRepository(
    private val notificationChannelJpaRepository: NotificationChannelJpaRepository,
    private val notificationChannelMapper: NotificationChannelMapper,
) : NotificationChannelRepository {
    override fun save(notificationChannel: NotificationChannel): NotificationChannel {
        val entity = notificationChannelJpaRepository.save(notificationChannelMapper.toEntity(notificationChannel))

        return notificationChannelMapper.toDto(entity)
    }

    override fun findByProjectId(channelId: Long): NotificationChannel? {
        return notificationChannelJpaRepository.findByProjectId(channelId)?.let(notificationChannelMapper::toDto)
    }
}
