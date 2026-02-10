package com.zjefersound.spring_boot_crash_course_kotlin

class BillNotFoundException(
    private val id: Long
): RuntimeException(
    "A bill with id '$id' was not found"
)
