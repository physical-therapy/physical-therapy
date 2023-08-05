package physicaltherapy.entity.user

import jakarta.persistence.*
import physicaltherapy.entity.BaseEntity

@Entity
internal class UserEntity(
    @Column(name = "name", nullable = false)
    var name: String,
): BaseEntity() {
}