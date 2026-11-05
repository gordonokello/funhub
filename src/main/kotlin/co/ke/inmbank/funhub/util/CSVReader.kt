package co.ke.inmbank.funhub.util

import co.ke.inmbank.funhub.dto.StaffDto
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import org.apache.commons.csv.CSVRecord
import java.io.File
import java.io.FileReader

object CSVReader {
    private val FORMAT: CSVFormat = CSVFormat.DEFAULT.builder()
        .setHeader()
        .setSkipHeaderRecord(true)
        .setTrim(true)
        .setIgnoreHeaderCase(true)
        .build()

    fun readStaffDetailsFromCSV(basePath: String): List<StaffDto> {
        FileReader(File(basePath.plus("/images/ict.csv"))).use { reader ->
            CSVParser(reader, FORMAT).use { csvParser ->
                return csvParser.map { record ->
                    StaffDto(
                        staffId = record.optional("staffId"),
                        staffName = record.optional("staffName"),
                        department = record.optional("department"),
                        groupNumber = record.optional("groupNumber"),
                        groupName = record.optional("groupName"),
                        emailAddress = record.optional("emailAddress")
                    )
                }
            }
        }
    }

    /** Returns the column value, or null if the column is absent from the header or the cell is blank. */
    private fun CSVRecord.optional(column: String): String? =
        if (isMapped(column)) get(column)?.takeIf { it.isNotBlank() } else null
}
