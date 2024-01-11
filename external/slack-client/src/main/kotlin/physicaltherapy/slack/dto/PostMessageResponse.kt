package physicaltherapy.slack.dto


import com.fasterxml.jackson.annotation.JsonProperty

data class PostMessageResponse(
    @JsonProperty("channel")
    val channel: String?,
    @JsonProperty("error")
    val error: Any?,
    @JsonProperty("message")
    val message: Message?,
    @JsonProperty("ok")
    val ok: Boolean,
    @JsonProperty("ts")
    val ts: String?
) {
    data class Message(
        @JsonProperty("app_id")
        val appId: String?,
        @JsonProperty("blocks")
        val blocks: List<Block?>?,
        @JsonProperty("bot_id")
        val botId: String?,
        @JsonProperty("bot_profile")
        val botProfile: BotProfile?,
        @JsonProperty("team")
        val team: String?,
        @JsonProperty("text")
        val text: String?,
        @JsonProperty("ts")
        val ts: String?,
        @JsonProperty("type")
        val type: String?,
        @JsonProperty("user")
        val user: String?
    ) {
        data class Block(
            @JsonProperty("block_id")
            val blockId: String?,
            @JsonProperty("elements")
            val elements: List<Element?>?,
            @JsonProperty("type")
            val type: String?
        ) {
            data class Element(
                @JsonProperty("elements")
                val elements: List<Element?>?,
                @JsonProperty("type")
                val type: String?
            ) {
                data class Element(
                    @JsonProperty("text")
                    val text: String?,
                    @JsonProperty("type")
                    val type: String?
                )
            }
        }

        data class BotProfile(
            @JsonProperty("app_id")
            val appId: String?,
            @JsonProperty("deleted")
            val deleted: Boolean?,
            @JsonProperty("icons")
            val icons: Icons?,
            @JsonProperty("id")
            val id: String?,
            @JsonProperty("name")
            val name: String?,
            @JsonProperty("team_id")
            val teamId: String?,
            @JsonProperty("updated")
            val updated: Int?
        ) {
            data class Icons(
                @JsonProperty("image_36")
                val image36: String?,
                @JsonProperty("image_48")
                val image48: String?,
                @JsonProperty("image_72")
                val image72: String?
            )
        }
    }
}
