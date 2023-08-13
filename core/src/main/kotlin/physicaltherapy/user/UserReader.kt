package physicaltherapy.user

import org.springframework.stereotype.Component
import java.lang.IllegalArgumentException

@Component
class UserReader(
    private val userRepository: UserRepository,
) {
    fun read(id: Long): User {
        return userRepository.read(id) ?: throw IllegalArgumentException("존재하지 않는 유저입니다. userId: $id")
    }
}
