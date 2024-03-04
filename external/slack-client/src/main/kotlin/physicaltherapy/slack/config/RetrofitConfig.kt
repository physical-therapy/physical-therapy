package physicaltherapy.slack.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.util.ResourceUtils.toURL
import physicaltherapy.slack.client.SlackApiClient
import physicaltherapy.slack.util.RetrofitUtils.createRetrofit

@Configuration
class RetrofitConfig(
    @Value("\${slack-api.base-url}")
    private val baseUrl: String,

    @Value("\${slack-api.access-token}")
    private val accessToken: String,
) {
    @Bean
    fun slackApiClient(): SlackApiClient = toURL(baseUrl)
        .createRetrofit(accessToken)
        .create(SlackApiClient::class.java)
}
