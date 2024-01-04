package physicaltherapy.slack.client

import physicaltherapy.slack.dto.PostMessageResponse
import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.Query

interface SlackApiClient {

    @POST("chat.postMessage")
    fun postMessage(
        @Query("channel") channel: String,
        @Query("text") text: String
    ): Call<PostMessageResponse>

}
