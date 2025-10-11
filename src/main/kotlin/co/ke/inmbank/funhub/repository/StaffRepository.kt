package co.ke.inmbank.funhub.repository

import co.ke.inmbank.funhub.model.StaffEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface StaffRepository: JpaRepository<StaffEntity, Long> {
    fun findByStaffId(staffId: String): Optional<StaffEntity>
}