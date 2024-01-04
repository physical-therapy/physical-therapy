package physicaltherapy.slack.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class PostMessageResponse(
    val channel: String?,
    val message: Message?,
    val ok: Boolean,
    val ts: String?,
    val error: String?
) {
    data class Message(
        val app_id: String,
        val blocks: List<Block>,
        val bot_id: String,
        val bot_profile: BotProfile,
        val team: String,
        val text: String,
        val ts: String,
        val type: String,
        val user: String
    ) {
        data class Block(
            val block_id: String,
            val elements: List<Element>,
            val type: String
        ) {
            data class Element(
                val elements: List<Element>,
                val type: String
            ) {
                data class Element(
                    val text: String,
                    val type: String
                )
            }
        }

        data class BotProfile(
            val app_id: String,
            val deleted: Boolean,
            val icons: Icons,
            val id: String,
            val name: String,
            val team_id: String,
            val updated: Int
        ) {
            data class Icons(
                val image_36: String,
                val image_48: String,
                val image_72: String
            )
        }
    }
}
