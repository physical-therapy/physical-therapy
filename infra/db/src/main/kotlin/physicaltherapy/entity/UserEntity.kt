package physicaltherapy.entity

import jakarta.persistence.*

@Entity
internal class UserEntity(
    @Column(name = "name", nullable = false)
    var name: String,
): BaseEntity() {
}