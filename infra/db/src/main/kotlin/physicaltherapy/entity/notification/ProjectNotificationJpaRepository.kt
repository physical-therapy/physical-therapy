package physicaltherapy.entity.notification

import org.springframework.data.jpa.repository.JpaRepository

internal interface ProjectNotificationJpaRepository : JpaRepository<ProjectNotification, Long>
