package com.zjefersound.spring_boot_crash_course_kotlin.repository

import com.zjefersound.spring_boot_crash_course_kotlin.BillDTO
import org.springframework.stereotype.Repository

@Repository
class BillRepository {

    val bills = mutableListOf<BillDTO>()

    fun insertBill(bill: BillDTO): BillDTO {
        bills.add(bill)
        return bill
    }

    fun getBillById(id: Long): BillDTO? = bills.find { it.id == id }

    fun deleteBill(id: Long): Boolean {
        val indexToDelete = bills.indexOfFirst { it.id == id }
        if (indexToDelete == -1) return false
        bills.removeAt(indexToDelete)
        return true
    }

    fun updateBill(bill: BillDTO): BillDTO? {
        val indexToUpdate = bills.indexOfFirst { it.id == bill.id }
        if (indexToUpdate == -1) return null
        bills[indexToUpdate] = bill
        return bill
    }

    fun getAllBills(): List<BillDTO> = bills
}