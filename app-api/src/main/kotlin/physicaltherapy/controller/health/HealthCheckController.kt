package physicaltherapy.controller.health

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HealthCheckController {

    @GetMapping("/health")
    fun checkHealth(): String = "OK"

    @GetMapping("/health2")
    fun checkHealth2(): String = "OK"
}
