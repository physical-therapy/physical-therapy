package physicaltherapy.entity.notification

import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.ManyToOne
import physicaltherapy.entity.BaseEntity
import physicaltherapy.entity.notificationChannel.NotificationChannel

@Entity
internal class SprintNotification(

    val sprintId: Long,

    @ManyToOne
    val notificationChannel: NotificationChannel,

    val content: String,

    val reactionCount: Int,

    @Enumerated(EnumType.STRING)
    val type: NotificationType,

) : BaseEntity()
