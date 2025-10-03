package co.ke.inmbank.funhub.config

import co.ke.inmbank.funhub.service.MailService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.ApplicationListener
import org.springframework.stereotype.Component

@Component
class ApplicationStartup(
    private val mailService: MailService,
): ApplicationListener<ApplicationReadyEvent> {
    val log: Logger = LoggerFactory.getLogger(ApplicationStartup::class.java)

    override fun onApplicationEvent(p0: ApplicationReadyEvent) {
        log.info("Application initialized for email!")
       mailService.sendSecretSantaEmail()
    }

}