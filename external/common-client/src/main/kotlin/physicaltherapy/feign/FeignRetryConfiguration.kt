package physicaltherapy.feign

import feign.Retryer
import org.springframework.context.annotation.Bean


class FeignRetryConfiguration {

    /**
     * 매 요청마다 100ms 만큼의 텀을 더 늘려서 재요청
     * 시도횟수 최대 5번
     */
    @Bean
    fun retry(): Retryer {
        return Retryer.Default()
    }
}