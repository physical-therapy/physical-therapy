package physicaltherapy.entity.notification

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import physicaltherapy.entity.BaseEntity
import physicaltherapy.entity.notificationChannel.NotificationChannel

@Entity
internal class ProjectNotification(

    @Column(name = "project_id", nullable = false)
    val projectId: Long,

    @ManyToOne
    @JoinColumn(name = "notification_channel_id", nullable = false)
    val notificationChannel: NotificationChannel,

    @Column(name = "content", nullable = false)
    val content: String,

    @Column(name = "reaction_count")
    private var reactionCount: Int = 0,

    @Enumerated(EnumType.STRING)
    @Column(name = "notification_type", nullable = false)
    val type: NotificationType,

) : BaseEntity()
