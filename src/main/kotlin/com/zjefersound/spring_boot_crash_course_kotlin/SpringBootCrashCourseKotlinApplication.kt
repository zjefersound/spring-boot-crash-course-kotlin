package com.zjefersound.spring_boot_crash_course_kotlin

import com.zjefersound.spring_boot_crash_course_kotlin.config.GlobalConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(
	GlobalConfig::class
)
class SpringBootCrashCourseKotlinApplication

fun main(args: Array<String>) {
	runApplication<SpringBootCrashCourseKotlinApplication>(*args)
}
