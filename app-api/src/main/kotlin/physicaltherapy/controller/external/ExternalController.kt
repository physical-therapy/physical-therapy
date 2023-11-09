package physicaltherapy.controller.external

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import physicaltherapy.slack.client.SlackApiClient
import physicaltherapy.slack.dto.PostMessageResponse
import retrofit2.Response

@RestController
class ExternalController(
    private val slackApiClient: SlackApiClient
) {

    @PostMapping("/external/post-message")
    fun addUser(
        @RequestParam("channel") channel: String,
        @RequestParam("text") text: String
    ): Response<PostMessageResponse> {
        return slackApiClient.postMessage(channel, text).execute()
    }

}
