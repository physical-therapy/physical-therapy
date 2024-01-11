package physicaltherapy.entity.notificationChannel

import jakarta.persistence.*
import physicaltherapy.entity.BaseEntity
import physicaltherapy.entity.project.ProjectEntity
import physicaltherapy.project.Project

@Entity
internal class NotificationChannelEntity(

    @Column(name = "channel_name", nullable = false, unique = true)
    val channelName: String,

    @Column(name = "project_id", nullable = false)
    val projectId: Long
) : BaseEntity()
