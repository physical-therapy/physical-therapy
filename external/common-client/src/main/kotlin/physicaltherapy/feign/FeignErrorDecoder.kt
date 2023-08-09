package physicaltherapy.feign

import feign.Response
import feign.codec.ErrorDecoder
import org.slf4j.LoggerFactory

class FeignErrorDecoder : ErrorDecoder {

    private val logger = LoggerFactory.getLogger(FeignErrorDecoder::class.java)
    override fun decode(methodKey: String?, response: Response): Exception {
        val request = response.request()
        val statusCode = response.status()

        logger.error("[ERROR] Request Failed. statusCode=$statusCode, key=${methodKey}, requestUrl=${request.url()}, request=$request")

        throw RuntimeException("$methodKey 요청에 실패하였습니다.")
    }
}