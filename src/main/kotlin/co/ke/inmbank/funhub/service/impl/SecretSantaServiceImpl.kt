package co.ke.inmbank.funhub.service.impl

import co.ke.inmbank.funhub.config.FunhubConfig
import co.ke.inmbank.funhub.enums.EmailStatus
import co.ke.inmbank.funhub.model.SecretSantaEntity
import co.ke.inmbank.funhub.repository.SecretSantaRepository
import co.ke.inmbank.funhub.service.SecretSantaService
import co.ke.inmbank.funhub.service.StaffService
import co.ke.inmbank.funhub.util.EmailUtil
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import kotlin.jvm.optionals.getOrNull
import kotlin.random.Random

@Service
class SecretSantaServiceImpl(
    private val secretSantaRepository: SecretSantaRepository,
    private val staffService: StaffService,
    private val funhubConfig: FunhubConfig
): SecretSantaService {

    override fun setUpSecretSanta(year: Int) {
        val staffList = staffService.findAllStaff()

        val optionalSecretSanta = secretSantaRepository.findCountByYear(year)
        if (optionalSecretSanta <= 0) {
            val result = assignSecretSanta(participants = staffList.map { it.id })
            result.forEach { (giver, recipient) -> persistSecretSanta(giver, recipient, year) }
        }
    }

    override fun sendSantaEmail() {
        val optionalPending = secretSantaRepository.findByEmailStatus(EmailStatus.PENDING)
        if (optionalPending.isPresent) {
            val result = optionalPending.get()
            result.forEach { entity ->
                val emailSent = sendEmail(entity)
                val emailStatus = when (emailSent) {
                    true -> EmailStatus.SENT
                    false -> EmailStatus.FAILED
                }
                entity.emailStatus = emailStatus
                entity.updatedAt = LocalDateTime.now()
                secretSantaRepository.save(entity)
            }
        }

    }

    fun persistSecretSanta(giver: Long, recipient: Long, year: Int) {
        val optionalSecretSanta = secretSantaRepository.findByGiverAndYear(giver, year)
        val giverEntity = staffService.findStaffById(giver)
        if (!optionalSecretSanta.isPresent) {
            val secretSantaEntity = SecretSantaEntity(
                giver       = giver,
                recipient   = recipient,
                emailStatus = EmailStatus.PENDING,
                sentTo      = giverEntity.getOrNull()?.email,
                year        = year
            )
            secretSantaRepository.save(secretSantaEntity)
        }
    }

    fun assignSecretSanta(participants: List<Long>): Map<Long, Long> {
        require (participants.size >= 2)
        val receivers = participants.toMutableList()
        val assignments = mutableMapOf<Long, Long>()

        do {
            receivers.shuffle(Random.Default)
        } while (participants.zip(receivers).any { it.first == it.second })

        participants.forEachIndexed { index, giver ->
            assignments[giver] = receivers[index]
        }

        return assignments
    }

    fun sendEmail(entity: SecretSantaEntity): Boolean {
        val giver       = staffService.findStaffById(entity.giver).getOrNull()
        val recipient   = staffService.findStaffById(entity.recipient).getOrNull()
        if (giver != null && recipient != null && entity.sentTo != null) {
            val template = EmailUtil.secretSantaTemplate(
                giver = "${giver.firstName} ${giver.otherNames}",
                recipient = "${recipient.firstName} ${recipient.otherNames}",
            )
            val emailSent = EmailUtil.sendMail(
                host = funhubConfig.host,
                from = funhubConfig.sender,
                to = entity.sentTo!!.lowercase(),
                subject = "Secret Santa",
                htmlText = template,
                imagePath = funhubConfig.imageFolder
            )
            return emailSent
        }
        return false
    }
}