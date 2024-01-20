package physicaltherapy.notificationChannel

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class NotificationChannelTest {

    @DisplayName("채널 이름은 필수입니다.")
    @Test
    fun testInitIfChannelNameIsBlank() {
        assertThrows(IllegalArgumentException::class.java) {
            NotificationChannel(
                channelName = "",
                projectId = 1L,
            )
        }
    }
}
