package co.ke.inmbank.funhub.service.impl

import co.ke.inmbank.funhub.config.FunhubConfig
import co.ke.inmbank.funhub.dto.StaffDto
import co.ke.inmbank.funhub.model.StaffEntity
import co.ke.inmbank.funhub.repository.StaffRepository
import co.ke.inmbank.funhub.service.StaffService
import co.ke.inmbank.funhub.util.CSVReader
import co.ke.inmbank.funhub.util.mapToStaffEntity
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class StaffServiceImpl(
    private val staffRepository: StaffRepository,
    private val funhubConfig: FunhubConfig
): StaffService {

    override fun syncStaffData() {
        val staffList = CSVReader.readStaffDetailsFromCSV(funhubConfig.imageFolder)
        staffList.forEach { staff -> persistStaffData(staff) }
    }

    override fun findAllStaff(): MutableList<StaffEntity> {
        return staffRepository.findAll()
    }

    override fun findStaffById(id: Long): Optional<StaffEntity> {
        return staffRepository.findById(id)
    }

    private fun persistStaffData(staffDto: StaffDto) {
        val optionalStaff = staffRepository.findByStaffId(staffDto.staffId!!)
        if (!optionalStaff.isPresent) {
            val staffEntity = staffDto.mapToStaffEntity()
            staffRepository.save(staffEntity)
        }
    }
}