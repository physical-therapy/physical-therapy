package physicaltherapy.slack.dto

import com.fasterxml.jackson.annotation.JsonProperty

private const val PROJECT_JOIN_EMOJI = "white_check_mark"

data class ReactionsGetResponse(
    @JsonProperty("channel")
    val channel: String?,
    @JsonProperty("message")
    val message: Message?,
    @JsonProperty("ok")
    val ok: Boolean?,
    @JsonProperty("type")
    val type: String?,
) {
    data class Message(
        @JsonProperty("permalink")
        val permalink: String?,
        @JsonProperty("reactions")
        val reactions: List<Reaction?>?,
        @JsonProperty("team")
        val team: String?,
        @JsonProperty("text")
        val text: String?,
        @JsonProperty("ts")
        val ts: String?,
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

    fun getReactions(): List<Message.Reaction> {
        return message?.let { it.reactions?.filterNotNull() } ?: emptyList()
    }

    fun findProjectJoinUsers(): List<String> {
        return getReactions()
            .find { it.name == PROJECT_JOIN_EMOJI }?.users?.filterNotNull() ?: emptyList()
    }
}
