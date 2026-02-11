package com.zjefersound.spring_boot_crash_course_kotlin.service

import com.zjefersound.spring_boot_crash_course_kotlin.BillDTO
import com.zjefersound.spring_boot_crash_course_kotlin.BillNotFoundException
import com.zjefersound.spring_boot_crash_course_kotlin.config.GlobalConfig
import com.zjefersound.spring_boot_crash_course_kotlin.repository.BillRepository
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class BillService(
    private val billRepository: BillRepository,

    @param:Value($$"${spring.application.version}")
    private val version: String,

    private val globalConfig: GlobalConfig
) {

    init {
        println("BillService running in version $version")
        println("System will work with currency: ${globalConfig.currency}")
    }

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