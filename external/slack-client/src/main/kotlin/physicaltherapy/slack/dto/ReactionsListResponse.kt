package physicaltherapy.slack.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class ReactionsListResponse(
    @JsonProperty("items")
    val items: List<Item?>?,
    @JsonProperty("ok")
    val ok: Boolean?,
    @JsonProperty("response_metadata")
    val responseMetadata: ResponseMetadata?,
) {
    data class Item(
        @JsonProperty("channel")
        val channel: String?,
        @JsonProperty("comment")
        val comment: Comment?,
        @JsonProperty("file")
        val `file`: File?,
        @JsonProperty("message")
        val message: Message?,
        @JsonProperty("type")
        val type: String?,
    ) {
        data class Comment(
            @JsonProperty("comment")
            val comment: String?,
            @JsonProperty("created")
            val created: Int?,
            @JsonProperty("id")
            val id: String?,
            @JsonProperty("reactions")
            val reactions: List<Reaction?>?,
            @JsonProperty("timestamp")
            val timestamp: Int?,
            @JsonProperty("type")
            val type: String?,
            @JsonProperty("user")
            val user: String?,
        ) {
            data class Reaction(
                @JsonProperty("count")
                val count: Int?,
                @JsonProperty("name")
                val name: String?,
                @JsonProperty("users")
                val users: List<String?>?,
            )
        }

        data class File(
            @JsonProperty("channels")
            val channels: List<String?>?,
            @JsonProperty("comments_count")
            val commentsCount: Int?,
            @JsonProperty("created")
            val created: Int?,
            @JsonProperty("id")
            val id: String?,
            @JsonProperty("name")
            val name: String?,
            @JsonProperty("reactions")
            val reactions: List<Reaction?>?,
            @JsonProperty("size")
            val size: Int?,
            @JsonProperty("title")
            val title: String?,
            @JsonProperty("user")
            val user: String?,
            @JsonProperty("username")
            val username: String?,
        ) {
            data class Reaction(
                @JsonProperty("count")
                val count: Int?,
                @JsonProperty("name")
                val name: String?,
                @JsonProperty("users")
                val users: List<String?>?,
            )
        }

        data class Message(
            @JsonProperty("bot_id")
            val botId: String?,
            @JsonProperty("reactions")
            val reactions: List<Reaction?>?,
            @JsonProperty("subtype")
            val subtype: String?,
            @JsonProperty("text")
            val text: String?,
            @JsonProperty("ts")
            val ts: String?,
            @JsonProperty("username")
            val username: String?,
        ) {
            data class Reaction(
                @JsonProperty("count")
                val count: Int?,
                @JsonProperty("name")
                val name: String?,
                @JsonProperty("users")
                val users: List<String?>?,
            )
        }
    }

    data class ResponseMetadata(
        @JsonProperty("next_cursor")
        val nextCursor: String?,
    )
}
