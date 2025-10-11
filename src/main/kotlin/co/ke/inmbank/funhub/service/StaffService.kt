package co.ke.inmbank.funhub.service

import co.ke.inmbank.funhub.model.StaffEntity
import java.util.Optional

interface StaffService {
    fun syncStaffData()
    fun findAllStaff(): MutableList<StaffEntity>
    fun findStaffById(id: Long): Optional<StaffEntity>
}