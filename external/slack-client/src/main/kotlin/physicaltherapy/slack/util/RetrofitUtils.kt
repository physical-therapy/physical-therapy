package physicaltherapy.slack.util

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.jsonMapper
import com.fasterxml.jackson.module.kotlin.kotlinModule
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import physicaltherapy.slack.config.OAuthInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import java.net.URL
import java.util.concurrent.TimeUnit

object RetrofitUtils {

    fun <T> Response<T>.getBody(): T {
        if (this.isSuccessful.not()) {
            throw RuntimeException("API call failed")
        }

        return this.body() ?: throw RuntimeException("API call failed")
    }

    fun URL.createRetrofit(accessToken : String): Retrofit {
        val client = OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )
            .addInterceptor(OAuthInterceptor("Bearer", accessToken))
            .connectTimeout(20000L, TimeUnit.SECONDS)
            .build()

        return Retrofit.Builder()
            .baseUrl(this.toString())
            .addConverterFactory(
                JacksonConverterFactory.create(
                    jsonMapper {
                        addModule(kotlinModule())
                        addModule(JavaTimeModule())
                    },
                ),
            )
            .client(client)
            .build()
    }

}
