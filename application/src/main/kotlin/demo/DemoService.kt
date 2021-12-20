package demo

import mu.KotlinLogging

class DemoService {

    fun demoService(): Demo {
        log.info { "invoked demoService" }
        return Demo()
    }

    companion object {
        private val log = KotlinLogging.logger {}
    }
}
