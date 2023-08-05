package physicaltherapy.entity.user

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository
import physicaltherapy.user.User
import physicaltherapy.user.UserRepository

@Repository
internal class UserEntityRepository(
    private val userJpaRepository: UserJpaRepository,
) : UserRepository {
    override fun add(name: String): Long {
        return userJpaRepository.save(
            UserEntity(name = name)
        ).id
    }

    override fun read(id: Long): User? {
        return userJpaRepository.findByIdOrNull(id)?.let {
            return User(
                id = it.id,
                name = it.name,
            )
        }
    }
}