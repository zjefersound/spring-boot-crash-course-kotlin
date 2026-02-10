package com.zjefersound.spring_boot_crash_course_kotlin

import com.zjefersound.spring_boot_crash_course_kotlin.service.BillService
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

@RestController
@RequestMapping("/bills")
class BillController(
    private val billService: BillService,
    // the name of the dependency matters, because the autowire tries to find
    // the type, then the name, then throws error if cant find the name AND
    // There is redundant beans
    private val restTemplate: RestTemplate
) {

    val bills = mutableListOf<BillDTO>()

    @GetMapping
    fun fetchBills(
        @RequestParam(value = "search", required = false ) search: String?,
    ): List<BillDTO> {
        return billService.getBills()

//        if (search.isNullOrBlank()) return bills
//        return bills.filter { it -> it.description.contains(search) }
    }

    @GetMapping("{id}")
    fun fetchBill(@PathVariable id: Long): BillDTO {

        return billService.getBillById(id)
    }

    @PostMapping
    fun postBill(
        @RequestBody bill: BillDTO
    ): BillDTO {
        return billService.insertBill(bill)
    }

    @PutMapping("{id}")
    fun updateBill(@PathVariable id: Long, @RequestBody bill: BillDTO): BillDTO {
        return billService.updateBill(bill)
    }

    @DeleteMapping("{id}")
    fun deleteBill(@PathVariable id: Long): Unit {
        return billService.deleteBill(id)
    }
}