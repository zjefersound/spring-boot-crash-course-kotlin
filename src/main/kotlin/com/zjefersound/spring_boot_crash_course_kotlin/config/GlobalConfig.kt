package com.zjefersound.spring_boot_crash_course_kotlin.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "global")
data class GlobalConfig(
    val language: String,
    val currency: String
) {
    init {
        println(language)
        println(currency)
    }
}