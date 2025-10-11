package co.ke.inmbank.funhub.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Index
import jakarta.persistence.Table

@Entity
@Table(
    name = "FH_STAFF",
    indexes = [
        Index(name = "idx_fh_staff_id",         columnList = "staff_id"),
        Index(name = "idx_fh_staff_department", columnList = "department"),
        Index(name = "idx_fh_staff_groupNumber",columnList = "group_number"),
        Index(name = "idx_fh_staff_groupName",  columnList = "group_name"),
    ]
)
class StaffEntity (
    @Column(name = "staff_id")
    var staffId: String,

    @Column(name = "first_name")
    var firstName: String?,

    @Column(name = "other_names")
    var otherNames: String?,

    @Column(name = "department")
    var department: String?,

    @Column(name = "group_number")
    var groupNumber: String?,

    @Column(name = "group_name")
    var groupName: String?,

    @Column(name = "email")
    var email: String?,
): BaseEntity()