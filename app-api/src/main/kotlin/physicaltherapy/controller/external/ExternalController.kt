package physicaltherapy.controller.external

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import physicaltherapy.slack.client.SlackApiClient
import physicaltherapy.slack.dto.PostMessageResponse
import physicaltherapy.slack.dto.ScheduleMessageResponse
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.ZonedDateTime

@RestController
class ExternalController(
    private val slackApiClient: SlackApiClient
) {

    @PostMapping("/external/post-message")
    fun addUser(
        @RequestParam("channel") channel: String,
        @RequestParam("text") text: String
    ): PostMessageResponse {
        return slackApiClient.postMessage(channel, null, text).execute().body()!!
    }

    @PostMapping("/external/schedule-message")
    fun scheduleMessage(
        @RequestParam("channel") channel: String,
        @RequestParam("post_at") postAt: String,
        @RequestParam("text") text: String
    ): ScheduleMessageResponse {
        val epochSecond = ZonedDateTime.now().plusSeconds(10).toEpochSecond()
        return slackApiClient.scheduleMessage(channel, epochSecond.toString(), text).execute().body()!!
    }

    @PostMapping("/external/list-scheduled-messages")
    fun listScheduledMessages(
        @RequestParam("channel") channel: String,
    ): PostMessageResponse {
        return slackApiClient.listScheduledMessages(channel).execute().body()!!
    }

    @PostMapping("/external/create-conversation")
    fun createConversation(
        @RequestParam("name") name: String,
        @RequestParam("is_private") isPrivate: Boolean = true,
    ): PostMessageResponse {
        return slackApiClient.createConversation(name, isPrivate).execute().body()!!
    }

    @PostMapping("/external/invite-to-conversation")
    fun inviteToConversation(
        @RequestParam("channel") channel: String,
        @RequestParam("users") users: String,
    ): PostMessageResponse {
        return slackApiClient.inviteToConversation(channel, users).execute().body()!!
    }

}
