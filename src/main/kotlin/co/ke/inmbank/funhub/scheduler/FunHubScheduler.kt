package co.ke.inmbank.funhub.scheduler

import co.ke.inmbank.funhub.service.SecretSantaService
import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class FunHubScheduler(
    private val secretSantaService: SecretSantaService,
) {
    private val logger = LoggerFactory.getLogger(FunHubScheduler::class.java)

    @Scheduled(cron = "\${inmbank.funhub.cron}", zone = "Africa/Nairobi")
    fun sendSecretSantaEmail() {
//        secretSantaService.sendSantaEmail()
    }
}