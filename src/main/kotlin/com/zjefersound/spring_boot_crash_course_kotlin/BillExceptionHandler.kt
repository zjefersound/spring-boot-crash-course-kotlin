package com.zjefersound.spring_boot_crash_course_kotlin

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice


// It's a good practice to create a exception handler per controller

@RestControllerAdvice
class BillExceptionHandler {

    @ExceptionHandler(BillNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun onBillNotFound(e: BillNotFoundException) = mapOf(
        "errorCode" to "QUOTE_NOT_FOUND",
        "message" to e.message
    )
}