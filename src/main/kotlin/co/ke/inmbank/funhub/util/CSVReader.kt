package co.ke.inmbank.funhub.util

import co.ke.inmbank.funhub.dto.StaffDto
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import java.io.File
import java.io.FileReader

object CSVReader {
    fun readStaffDetailsFromCSV(basePath: String): List<StaffDto> {
        val staff = mutableListOf<StaffDto>()
        FileReader(File(basePath.plus("/images/iCube.csv"))).use { reader ->
            CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader()).use { csvParser ->
                for (record in csvParser) {
                    val id          = record["staffId"]
                    val name        = record["staffName"]
                    val department  = record["department"]
                    val groupNumber = record["groupNumber"]
                    val groupName   = record["groupName"]
                    val email       = record["emailAddress"]
                    staff.add(
                        StaffDto(
                            staffId = id,
                            staffName = name,
                            department = department,
                            groupNumber = groupNumber,
                            groupName = groupName,
                            emailAddress = email
                        )
                    )
                }
            }
        }
        return staff
    }
}