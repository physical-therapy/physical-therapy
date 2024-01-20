package physicaltherapy.external.service

import org.springframework.stereotype.Service
import physicaltherapy.slack.client.SlackApiClient
import physicaltherapy.slack.dto.CreateConversationResponse

@Service
class SlackService(
    private val slackApiClient: SlackApiClient
) {

    fun sendMessage(channel: String, text: String) {
        try {
            slackApiClient.postMessage(channel, null, text).execute()
        } catch (e: Exception) {
            throw RuntimeException("메시지 전송에 실패했습니다. channel: $channel, text: $text")
        }
    }

    fun isExistChannel(channelName: String): Boolean {
        val execute = try {
            slackApiClient.listConversations().execute()
        } catch (e: Exception) {
            throw RuntimeException("채널 목록 조회에 실패했습니다.")
        }

        execute.body()?.channels?.forEach {
            if (it?.name == channelName) {
                return true
            }
        }
        return false
    }

    fun createChannel(channelName: String) {
        try {
            slackApiClient.createConversation(channelName, false).execute()
        } catch (e: Exception) {
            throw RuntimeException("채널 생성에 실패했습니다. channelName: $channelName")
        }
    }
}
