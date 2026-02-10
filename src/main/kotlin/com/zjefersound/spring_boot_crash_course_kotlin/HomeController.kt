package com.zjefersound.spring_boot_crash_course_kotlin

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HomeController {

    @GetMapping("/home")
    fun home() = "Chaaaama"
}