package physicaltherapy.feign

import feign.Logger
import org.springframework.cloud.openfeign.FeignFormatterRegistrar
import org.springframework.context.annotation.Bean
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar

class FeignConfiguration {

    @Bean
    fun localDateFeignFormatterRegister(): FeignFormatterRegistrar {
        return FeignFormatterRegistrar {
            val registrar = DateTimeFormatterRegistrar().apply {
                setUseIsoFormat(true)
                registerFormatters(it)
            }
        }
    }

    @Bean
    fun feignLoggerLevel(): Logger.Level {
        return Logger.Level.FULL
    }
}