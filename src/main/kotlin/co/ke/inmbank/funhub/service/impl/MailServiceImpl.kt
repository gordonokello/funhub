package co.ke.inmbank.funhub.service.impl

import co.ke.inmbank.funhub.config.FunhubConfig
import co.ke.inmbank.funhub.service.MailService
import co.ke.inmbank.funhub.util.EmailUtil
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class MailServiceImpl(
    private val funhubConfig: FunhubConfig
): MailService {
    val logger = LoggerFactory.getLogger(MailServiceImpl::class.java)

    override fun sendSecretSantaEmail() {
        val template = EmailUtil.secretSantaTemplate(
            giver = "Gordon",
            recipient = "Wladek",
        )
        val emailSent = EmailUtil.sendMail(
            host = funhubConfig.host,
            from = funhubConfig.sender,
            to = "gordon.okello@imbank.co.ke",
            subject = "Secret Santa",
            htmlText = template,
            imagePath = funhubConfig.imageFolder
        )

        logger.info("Email status $emailSent")
    }
}