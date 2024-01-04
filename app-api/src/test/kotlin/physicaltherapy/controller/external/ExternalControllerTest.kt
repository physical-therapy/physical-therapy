package physicaltherapy.controller.external

import org.assertj.core.internal.Uris
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import physicaltherapy.AppApiApplication

@AutoConfigureMockMvc
@SpringBootTest(classes = [AppApiApplication::class], webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
class ExternalControllerTest() {

    @Autowired
    protected lateinit var mockMvc: MockMvc

    @Test
    @Order(1)
    @DisplayName("Slack 메시지 전송, 성공")
    fun postMessageSuccess() {

        val uri = "/external/post-message"

        mockMvc.perform(
            post(uri)
                .param("channel", "test-channel")
                .param("text", "hi")
        )
            .andExpect(status().isOk())

    }

}
