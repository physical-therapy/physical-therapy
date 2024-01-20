package physicaltherapy.notificationChannel

data class NotificationChannel(
    val channelName: String,
    val projectId: Long,
) {
    init {
        require(channelName.isNotBlank()) { "채널 이름은 필수입니다." }
    }
}
