package physicaltherapy.slack.dto


import com.fasterxml.jackson.annotation.JsonProperty

data class CreateConversationResponse(
    @JsonProperty("channel")
    val channel: Channel?,
    @JsonProperty("ok")
    val ok: Boolean?
) {
    data class Channel(
        @JsonProperty("context_team_id")
        val contextTeamId: String?,
        @JsonProperty("created")
        val created: Int?,
        @JsonProperty("creator")
        val creator: String?,
        @JsonProperty("id")
        val id: String?,
        @JsonProperty("is_archived")
        val isArchived: Boolean?,
        @JsonProperty("is_channel")
        val isChannel: Boolean?,
        @JsonProperty("is_ext_shared")
        val isExtShared: Boolean?,
        @JsonProperty("is_general")
        val isGeneral: Boolean?,
        @JsonProperty("is_group")
        val isGroup: Boolean?,
        @JsonProperty("is_im")
        val isIm: Boolean?,
        @JsonProperty("is_member")
        val isMember: Boolean?,
        @JsonProperty("is_mpim")
        val isMpim: Boolean?,
        @JsonProperty("is_org_shared")
        val isOrgShared: Boolean?,
        @JsonProperty("is_pending_ext_shared")
        val isPendingExtShared: Boolean?,
        @JsonProperty("is_private")
        val isPrivate: Boolean?,
        @JsonProperty("is_shared")
        val isShared: Boolean?,
        @JsonProperty("last_read")
        val lastRead: String?,
        @JsonProperty("name")
        val name: String?,
        @JsonProperty("name_normalized")
        val nameNormalized: String?,
        @JsonProperty("parent_conversation")
        val parentConversation: Any?,
        @JsonProperty("pending_connected_team_ids")
        val pendingConnectedTeamIds: List<Any?>?,
        @JsonProperty("pending_shared")
        val pendingShared: List<Any?>?,
        @JsonProperty("previous_names")
        val previousNames: List<Any?>?,
        @JsonProperty("priority")
        val priority: Int?,
        @JsonProperty("purpose")
        val purpose: Purpose?,
        @JsonProperty("shared_team_ids")
        val sharedTeamIds: List<String?>?,
        @JsonProperty("topic")
        val topic: Topic?,
        @JsonProperty("unlinked")
        val unlinked: Int?,
        @JsonProperty("updated")
        val updated: Long?
    ) {
        data class Purpose(
            @JsonProperty("creator")
            val creator: String?,
            @JsonProperty("last_set")
            val lastSet: Int?,
            @JsonProperty("value")
            val value: String?
        )

        data class Topic(
            @JsonProperty("creator")
            val creator: String?,
            @JsonProperty("last_set")
            val lastSet: Int?,
            @JsonProperty("value")
            val value: String?
        )
    }
}
