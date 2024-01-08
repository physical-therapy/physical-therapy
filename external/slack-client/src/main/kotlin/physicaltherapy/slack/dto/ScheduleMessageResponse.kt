package physicaltherapy.slack.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class ScheduleMessageResponse(
    val channel: String, // C064XCKC937
    val message: Message,
    val ok: Boolean, // true
    val post_at: Int, // 1704402402
    val scheduled_message_id: String // Q06CETZ018B
) {
    data class Message(
        val app_id: String, // A065CTTC6MP
        val blocks: List<Block>,
        val bot_id: String, // B065096EZA6
        val bot_profile: BotProfile,
        val team: String, // T05LF6M59NG
        val text: String, // schedule Test
        val type: String, // message
        val user: String // U065CTWAFDF
    ) {
        data class Block(
            val block_id: String, // uyNT
            val elements: List<Element>,
            val type: String // rich_text
        ) {
            data class Element(
                val elements: List<Element>,
                val type: String // rich_text_section
            ) {
                data class Element(
                    val text: String, // schedule Test
                    val type: String // text
                )
            }
        }

        data class BotProfile(
            val app_id: String, // A065CTTC6MP
            val deleted: Boolean, // false
            val icons: Icons,
            val id: String, // B065096EZA6
            val name: String, // PhysicalTherapyApi
            val team_id: String, // T05LF6M59NG
            val updated: Int // 1704369084
        ) {
            data class Icons(
                val image_36: String, // https://a.slack-edge.com/80588/img/plugins/app/bot_36.png
                val image_48: String, // https://a.slack-edge.com/80588/img/plugins/app/bot_48.png
                val image_72: String // https://a.slack-edge.com/80588/img/plugins/app/service_72.png
            )
        }
    }
}
