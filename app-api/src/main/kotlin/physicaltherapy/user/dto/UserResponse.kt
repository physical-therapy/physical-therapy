package physicaltherapy.controller.user.dto

import physicaltherapy.user.User

data class UserResponse(
    val name: String,
) {
    companion object {
        fun of(user: User): UserResponse {
            return UserResponse(name = user.name)
        }
    }

}
