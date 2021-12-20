package demo

import mu.KotlinLogging
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class DemoApplication {

    @Bean
    fun demoService(): DemoService {
        log.info { "creating 'demoService' bean" }
        return DemoService()
    }

    companion object {
        private val log = KotlinLogging.logger {}
    }
}
