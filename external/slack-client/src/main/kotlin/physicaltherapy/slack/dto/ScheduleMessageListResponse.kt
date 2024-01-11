package physicaltherapy.slack.dto


import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class ScheduleMessageListResponse(
    @JsonProperty("ok")
    val ok: Boolean?,
    @JsonProperty("response_metadata")
    val responseMetadata: ResponseMetadata?,
    @JsonProperty("scheduled_messages")
    val scheduledMessages: List<ScheduledMessage?>?
) {
    data class ResponseMetadata(
        @JsonProperty("next_cursor")
        val nextCursor: String?
    )

    data class ScheduledMessage(
        @JsonProperty("channel_id")
        val channelId: String?,
        @JsonProperty("date_created")
        val dateCreated: Int?,
        @JsonProperty("id")
        val id: String?,
        @JsonProperty("post_at")
        val postAt: Int?,
        @JsonProperty("text")
        val text: String?
    )
}
