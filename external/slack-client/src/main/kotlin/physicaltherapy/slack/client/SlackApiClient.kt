package physicaltherapy.slack.client

import physicaltherapy.slack.dto.*
import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * @see <a href="https://api.slack.com/web">Slack Web API</a>
 */
interface SlackApiClient {

    /**
     * @see <a href="https://api.slack.com/methods/chat.postMessage">Chat Post Message</a>
     */
    @POST("chat.postMessage")
    fun postMessage(
        @Query("channel") channel: String,
        @Query("thread_ts") threadTs: String?,
        @Query("text") text: String
    ): Call<PostMessageResponse>

    /**
     * @see <a href="https://api.slack.com/methods/chat.scheduleMessage">Chat Schedule Message</a>
     */
    @POST("chat.scheduleMessage")
    fun scheduleMessage(
        @Query("channel") channel: String,
        @Query("post_at") postAt: String,
        @Query("text") text: String
    ): Call<ScheduleMessageResponse>

    /**
     * @see <a href="https://api.slack.com/methods/chat.scheduledMessages.list">Chat Scheduled Messages List</a>
     */
    @POST("chat.scheduledMessages.list")
    fun listScheduledMessages(
        @Query("channel") channel: String,
    ): Call<ScheduleMessageListResponse>

    /**
     * @see <a href="https://api.slack.com/methods/conversations.create">Conversations Create</a>
     */
    @POST("conversations.create")
    fun createConversation(
        @Query("name") name: String,
        @Query("is_private") isPrivate: Boolean = true,
    ): Call<CreateConversationResponse>

    /**
     * @see <a href="https://api.slack.com/methods/conversations.invite">Conversations Invite</a>
     */
    @POST("conversations.invite")
    fun inviteToConversation(
        @Query("channel") channel: String,
        @Query("users") users: String,
    ): Call<InviteConversationResponse>

    /**
     * @see <a href="https://api.slack.com/methods/conversations.list">Conversations List</a>
     */
    @POST("conversations.list")
    fun listConversations(): Call<ConversationListResponse>

}
