package com.zjefersound.spring_boot_crash_course_kotlin

import org.hibernate.validator.constraints.Length

data class BillDTO (

    val id: Long,

    @field:Length(min = 3, max = 255, message = "Bill ID must be between 3 and 255")
    val description: String,

    val amount: Long
)