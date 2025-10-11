package co.ke.inmbank.funhub.model

import co.ke.inmbank.funhub.enums.EmailStatus
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Index
import jakarta.persistence.Table

@Entity
@Table(
    name = "FH_SECRET_SANTA",
    indexes = [
        Index(name = "idx_fh_secret_santa_giver",      columnList   = "giver",),
        Index(name = "idx_fh_secret_santa_recipient",   columnList  = "recipient"),
        Index(name = "idx_fh_secret_santa_emailStatus", columnList  = "emailStatus"),
        Index(name = "idx_fh_secret_santa_year",        columnList  = "year"),
    ]
)
class SecretSantaEntity (//year and giver should form some unique key
    @Column(name = "giver")
    var giver: Long,

    @Column(name = "recipient")
    var recipient: Long,

    @Column(name = "email_status")
    @Enumerated(EnumType.STRING)
    var emailStatus: EmailStatus,

    @Column(name = "sent_to")
    var sentTo: String?,

    @Column(name = "year")
    var year: Int?,
): BaseEntity()