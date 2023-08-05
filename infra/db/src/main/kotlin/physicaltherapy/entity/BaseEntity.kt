package physicaltherapy.entity

import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.ZonedDateTime

@MappedSuperclass
internal class BaseEntity {

    @CreationTimestamp
    val createdAt: ZonedDateTime? = null

    @UpdateTimestamp
    var updatedAt: ZonedDateTime? = null
        protected set

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L
}