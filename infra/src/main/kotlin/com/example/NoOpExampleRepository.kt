package com.example

import mu.KotlinLogging
import org.springframework.stereotype.Component

@Component
class NoOpExampleRepository : ExampleRepository {

    companion object {
        private val log = KotlinLogging.logger {}
    }

    init {
        log.info("Initializing NoOpExampleRepository")
    }

    override fun example(model: Example) {
        log.info("method: example(Example)")
    }
}
