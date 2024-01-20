package physicaltherapy.controller.user

import org.springframework.web.bind.annotation.*
import physicaltherapy.controller.user.dto.NewUserRequest
import physicaltherapy.controller.user.dto.NewUserResponse
import physicaltherapy.controller.user.dto.UserResponse
import physicaltherapy.user.UserService

@RestController
class UserController(
    private val userService: UserService
) {
    @GetMapping("/users/{userId}")
    fun findUser(
        @PathVariable userId: Long
    ): UserResponse {
        val user = userService.read(userId)
        return UserResponse.of(user)
    }
}
