package physicaltherapy.external.service

import org.springframework.stereotype.Service
import physicaltherapy.slack.client.SlackApiClient
import physicaltherapy.slack.dto.PostMessageResponse
import physicaltherapy.slack.dto.ReactionsGetResponse
import physicaltherapy.slack.dto.UserListResponse

@Service
class SlackService(
    private val slackApiClient: SlackApiClient,
) {
    fun sendMessage(
        channel: String,
        text: String,
    ): PostMessageResponse {
        return try {
            slackApiClient.postMessage(channel, null, text).execute().body()!!
        } catch (e: Exception) {
            throw RuntimeException("메시지 전송에 실패했습니다. channel: $channel, text: $text")
        }
    }

    fun isExistChannel(channelName: String): Boolean {
        val execute =
            try {
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

    fun inviteToChannel(
        channelName: String,
        users: List<String>,
    ) {
        try {
            slackApiClient.inviteToConversation(channel = channelName, users = users.joinToString(",")).execute()
        } catch (e: Exception) {
            throw RuntimeException("채널 초대에 실패했습니다. channelName: $channelName, users: $users")
        }
    }

    fun getUserList(): UserListResponse {
        return try {
            slackApiClient.listUsers().execute().body()!!
        } catch (e: Exception) {
            throw RuntimeException("유저 리스트 조회에 실패했습니다.")
        }
    }

    fun getReactions(channelName: String, timestamp: String): ReactionsGetResponse {
        return try {
            slackApiClient.reactionsGet(channelName, timestamp)
                .execute()
                .body()!!
        } catch (e: Exception) {
            throw RuntimeException("모집글 리액션 조회에 실패했습니다.")
        }
    }
}
