package com.example

import mu.KotlinLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ExampleRestController(private val service: ExampleService) {

    companion object {
        private val log = KotlinLogging.logger {}
    }

    init {
        log.info("Initializing ExampleRestController")
    }

    @GetMapping
    fun example() {
        log.info("method: example()")
        service.example(Example())
    }
}
