package com.zjefersound.spring_boot_crash_course_kotlin

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.web.client.ResponseErrorHandler
import org.springframework.web.client.RestTemplate

@Configuration
class RestConfig {

    @Bean
    @Primary // <--- used as fallback
    fun restTemplate(): RestTemplate {
        return RestTemplate().apply {
            errorHandler = ResponseErrorHandler { response ->
                response.body.use {
                    it.readBytes().decodeToString().startsWith("ERROR")
                }
            }
        }
    }

    @Bean
    fun restTemplate2(): RestTemplate {
        return RestTemplate().apply {
            errorHandler = ResponseErrorHandler { response ->
                response.body.use {
                    it.readBytes().decodeToString().startsWith("ERROR")
                }
            }
        }
    }
}