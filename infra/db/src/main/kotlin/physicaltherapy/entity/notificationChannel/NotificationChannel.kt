package physicaltherapy.entity.notificationChannel

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne
import physicaltherapy.entity.BaseEntity

@Entity
internal class NotificationChannel(

    @Column(name = "channel_name", nullable = false, unique = true)
    val channelName: String,

//    @OneToOne
//    @JoinColumn(name = "project_id", nullable = false)
//    val projectId: Project
) : BaseEntity()
