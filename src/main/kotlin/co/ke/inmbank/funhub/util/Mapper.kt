package co.ke.inmbank.funhub.util

import co.ke.inmbank.funhub.dto.StaffDto
import co.ke.inmbank.funhub.model.StaffEntity

fun StaffDto.mapToStaffEntity(): StaffEntity = StaffEntity(
    staffId     = this.staffId!!,
    firstName   = splitName(this.staffName!!).first,
    otherNames  = splitName(this.staffName).second,
    department  = this.department,
    groupNumber = this.groupNumber,
    groupName   = this.groupName,
    email       = this.emailAddress
)