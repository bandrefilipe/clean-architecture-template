package com.example

import mu.KotlinLogging
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class ExampleApplication {

    companion object {
        private val log = KotlinLogging.logger {}
    }

    @Bean
    fun exampleService(repository: ExampleRepository): ExampleService {
        log.info { "Creating bean: exampleService" }
        return ExampleService(repository)
    }
}

fun main(args: Array<String>) {
    runApplication<ExampleApplication>(*args)
}
