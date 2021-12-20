package demo

import mu.KotlinLogging
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class DemoController(
    private val service: DemoService,
) {

    @RequestMapping
    fun demoEndpoint(): Demo {
        log.info { "invoked demoEndpoint" }
        return service.demoService()
    }

    companion object {
        private val log = KotlinLogging.logger {}
    }
}
