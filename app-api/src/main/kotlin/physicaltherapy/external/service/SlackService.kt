package physicaltherapy.external.service

import org.springframework.stereotype.Service
import physicaltherapy.slack.client.SlackApiClient

@Service
class SlackService(
    private val slackApiClient: SlackApiClient
) {

    fun isExistChannel(channelName: String): Boolean {
        slackApiClient.listConversations().execute().body()?.channels?.forEach {
            if(it?.name == channelName) {
                return true
            }
        }
        return false
    }
}
