package physicaltherapy.slack.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.util.ResourceUtils.toURL
import physicaltherapy.slack.client.SlackApiClient
import physicaltherapy.slack.util.RetrofitUtils.createRetrofit

@Configuration
class RetrofitConfig {

    companion object {
        const val BASE_URL = "https://slack.com/api/"
        const val ACCESS_TOKEN = "xoxb-5695225179764-6182948355457-iPFXlIOAv6zGxHdlhcZUXynv"
    }

    @Bean
    fun slackApiClient(): SlackApiClient = toURL(BASE_URL)
        .createRetrofit(ACCESS_TOKEN)
        .create(SlackApiClient::class.java)

}
