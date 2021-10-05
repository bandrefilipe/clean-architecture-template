package com.example

import mu.KotlinLogging

class ExampleService(private val repository: ExampleRepository) {

    companion object {
        private val log = KotlinLogging.logger {}
    }

    init {
        log.info("Initializing ExampleService")
    }

    fun example(model: Example) {
        log.info("method: example(Example)")
        repository.example(model)
    }
}
