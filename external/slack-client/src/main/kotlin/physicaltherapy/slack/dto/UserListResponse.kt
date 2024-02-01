package physicaltherapy.slack.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class UserListResponse(
    @JsonProperty("cache_ts")
    val cacheTs: Int?,
    @JsonProperty("members")
    val members: List<Member>?,
    @JsonProperty("ok")
    val ok: Boolean?,
    @JsonProperty("response_metadata")
    val responseMetadata: ResponseMetadata?,
) {
    data class Member(
        @JsonProperty("color")
        val color: String?,
        @JsonProperty("deleted")
        val deleted: Boolean?,
        @JsonProperty("has_2fa")
        val has2fa: Boolean?,
        @JsonProperty("id")
        val id: String?,
        @JsonProperty("is_admin")
        val isAdmin: Boolean?,
        @JsonProperty("is_app_user")
        val isAppUser: Boolean?,
        @JsonProperty("is_bot")
        val isBot: Boolean?,
        @JsonProperty("is_owner")
        val isOwner: Boolean?,
        @JsonProperty("is_primary_owner")
        val isPrimaryOwner: Boolean?,
        @JsonProperty("is_restricted")
        val isRestricted: Boolean?,
        @JsonProperty("is_ultra_restricted")
        val isUltraRestricted: Boolean?,
        @JsonProperty("name")
        val name: String?,
        @JsonProperty("profile")
        val profile: Profile?,
        @JsonProperty("real_name")
        val realName: String?,
        @JsonProperty("team_id")
        val teamId: String?,
        @JsonProperty("tz")
        val tz: String?,
        @JsonProperty("tz_label")
        val tzLabel: String?,
        @JsonProperty("tz_offset")
        val tzOffset: Int?,
        @JsonProperty("updated")
        val updated: Int?,
    ) {
        data class Profile(
            @JsonProperty("avatar_hash")
            val avatarHash: String?,
            @JsonProperty("display_name")
            val displayName: String?,
            @JsonProperty("display_name_normalized")
            val displayNameNormalized: String?,
            @JsonProperty("email")
            val email: String?,
            @JsonProperty("first_name")
            val firstName: String?,
            @JsonProperty("image_1024")
            val image1024: String?,
            @JsonProperty("image_192")
            val image192: String?,
            @JsonProperty("image_24")
            val image24: String?,
            @JsonProperty("image_32")
            val image32: String?,
            @JsonProperty("image_48")
            val image48: String?,
            @JsonProperty("image_512")
            val image512: String?,
            @JsonProperty("image_72")
            val image72: String?,
            @JsonProperty("image_original")
            val imageOriginal: String?,
            @JsonProperty("last_name")
            val lastName: String?,
            @JsonProperty("phone")
            val phone: String?,
            @JsonProperty("real_name")
            val realName: String?,
            @JsonProperty("real_name_normalized")
            val realNameNormalized: String?,
            @JsonProperty("skype")
            val skype: String?,
            @JsonProperty("status_emoji")
            val statusEmoji: String?,
            @JsonProperty("status_text")
            val statusText: String?,
            @JsonProperty("team")
            val team: String?,
            @JsonProperty("title")
            val title: String?,
        )
    }

    data class ResponseMetadata(
        @JsonProperty("next_cursor")
        val nextCursor: String?,
    )
}
