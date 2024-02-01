package physicaltherapy.entity.notificationChannel

import jakarta.persistence.*
import physicaltherapy.entity.BaseEntity

@Entity
internal class NotificationChannelEntity(
    @Column(name = "channel_name", nullable = false, unique = true)
    val channelName: String,
    @Column(name = "project_id", nullable = false)
    val projectId: Long,
) : BaseEntity()
