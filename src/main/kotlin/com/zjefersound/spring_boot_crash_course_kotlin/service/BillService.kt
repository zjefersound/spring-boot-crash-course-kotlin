package com.zjefersound.spring_boot_crash_course_kotlin.service

import com.zjefersound.spring_boot_crash_course_kotlin.BillDTO
import com.zjefersound.spring_boot_crash_course_kotlin.BillNotFoundException
import com.zjefersound.spring_boot_crash_course_kotlin.repository.BillRepository
import org.springframework.stereotype.Service

@Service
class BillService(
    private val billRepository: BillRepository
) {
    fun getBills(): List<BillDTO> {
        return billRepository.getAllBills()
    }

    fun getBillById(id: Long): BillDTO {
        return billRepository.getBillById(id) ?: throw BillNotFoundException(id)
    }

    fun insertBill(bill: BillDTO): BillDTO {
        return billRepository.insertBill(bill)
    }

    fun updateBill(bill: BillDTO): BillDTO {
        return billRepository.updateBill(bill) ?: throw BillNotFoundException(bill.id)
    }

    fun deleteBill(billId:Long) {
        if(!billRepository.deleteBill(billId)) {
            throw BillNotFoundException(billId)
        }
    }
}