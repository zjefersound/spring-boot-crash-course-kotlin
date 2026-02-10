package com.zjefersound.spring_boot_crash_course_kotlin

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.HttpClientErrorException

@RestController
@RequestMapping("/bills")
class BillController {

    val bills = mutableListOf<BillDTO>()

    @GetMapping
    fun loadBills(): List<BillDTO> = bills

    @PostMapping
    fun postBill(
        @RequestBody bill: BillDTO
    ): BillDTO {
        bills.add(bill)
        return bill
    }

    @PutMapping("{id}")
    fun updateBill(@PathVariable id: Long, @RequestBody bill: BillDTO): BillDTO {
        val indexToUpdate = bills.indexOfFirst { it.id == id }

//        if (indexToUpdate == -1) return error
        bills[indexToUpdate] = bill
        return bill
    }

    @DeleteMapping("{id}")
    fun deleteBill(@PathVariable id: Long): Unit {
        bills.removeIf { it.id == id }
    }
}