package physicaltherapy.entity.notificationChannel

import jakarta.persistence.Column
import jakarta.persistence.Entity
import physicaltherapy.entity.BaseEntity

@Entity
internal class NotificationChannel(

    @Column(nullable = false)
    val channelName: String,

//    @OneToOne
//    val projectId: Project
) : BaseEntity()
