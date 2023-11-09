package physicaltherapy.controller.external

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import physicaltherapy.slack.client.SlackApiClient
import physicaltherapy.slack.dto.PostMessageResponse

@RestController
class ExternalController(
    private val slackApiClient: SlackApiClient
) {

    @PostMapping("/external/post-message")
    fun addUser(
        @RequestParam("channel") channel: String,
        @RequestParam("text") text: String
    ): PostMessageResponse {
        return slackApiClient.postMessage(channel, text).execute().body()!!
    }

}
