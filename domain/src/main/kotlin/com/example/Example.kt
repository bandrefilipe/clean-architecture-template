package com.example

import mu.KotlinLogging

class Example {

    companion object {
        private val log = KotlinLogging.logger {}
    }

    init {
        log.info("Initializing Example")
    }

    fun sum(augend: Int, addend: Int): Int {
        log.info("method: sum(Int, Int)")
        return augend + addend
    }
}
