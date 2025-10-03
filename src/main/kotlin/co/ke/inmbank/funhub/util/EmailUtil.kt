package co.ke.inmbank.funhub.util

import jakarta.activation.DataHandler
import jakarta.activation.FileDataSource
import jakarta.mail.BodyPart
import jakarta.mail.Message
import jakarta.mail.Multipart
import jakarta.mail.Session
import jakarta.mail.Transport
import jakarta.mail.internet.InternetAddress
import jakarta.mail.internet.MimeBodyPart
import jakarta.mail.internet.MimeMessage
import jakarta.mail.internet.MimeMultipart
import org.springframework.core.io.FileSystemResource
import java.util.Date
import java.util.Properties

object EmailUtil {

    fun secretSantaTemplate(giver: String, recipient: String, budget: String, date: String, location: String, organizer: String): String {
        return """
        <!DOCTYPE html>
        <html>
        <head>
          <meta charset="UTF-8">
          <title>Your Secret Santa Assignment</title>
          <style>
            body {
              font-family: Arial, sans-serif;
              background-color: #f9f9f9;
              color: #333;
              padding: 20px;
            }
            .container {
              background-color: #fff;
              border-radius: 8px;
              padding: 30px;
              max-width: 600px;
              margin: auto;
              box-shadow: 0 2px 8px rgba(0,0,0,0.1);
            }
            h1 {
              color: #d6336c;
              text-align: center;
            }
            .highlight {
              font-weight: bold;
              color: #007bff;
            }
            .footer {
              margin-top: 30px;
              font-size: 0.9em;
              color: #666;
              text-align: center;
            }
          </style>
        </head>
        <body>
          <div class="container">
            <h1>🎅 Your Secret Santa Assignment Is Here!</h1>
            <p>Hi <span class="highlight">$giver</span>,</p>

            <p>It’s that magical time of year again—and you’ve officially been assigned your Secret Santa recipient! 🎁</p>

            <p>You’ll be gifting to: <span class="highlight">$recipient</span></p>

            <p>Here are a few tips to make it special:</p>
            <ul>
              <li>Keep it anonymous until the big reveal!</li>
              <li>Aim for something thoughtful and fun.</li>
              <li>Suggested budget: <span class="highlight">$budget</span></li>
            </ul>

            <p>🎄 <strong>Gift exchange date:</strong> $date<br>
               📍 <strong>Location:</strong> $location</p>

            <p>If you have any questions or need help, feel free to reach out.</p>

            <p>Happy gifting,<br>
            <span class="highlight">$organizer</span></p>

            <div class="footer">
              <p>✨ Secret Santa 2025 ✨</p>
            </div>
          </div>
        </body>
        </html>
    """.trimIndent()
    }

    fun sendMail(host: String, from: String, to: String, subject: String, htmlText: String, imagePath: String): Boolean {
        val defaultBanner = FileSystemResource(imagePath.plus("banner.jpg")).file
        val defaultBannerDataSource = FileDataSource(defaultBanner.path)

        val defaultBannerBodyPart = MimeBodyPart()
        defaultBannerBodyPart.dataHandler = DataHandler(defaultBannerDataSource)
        defaultBannerBodyPart.setHeader("Content-ID", "<image>")

        val messageBodyPart: BodyPart = MimeBodyPart()
        messageBodyPart.setContent(htmlText, "text/html")

        val multipart: Multipart = MimeMultipart()
        multipart.addBodyPart(defaultBannerBodyPart)
        multipart.addBodyPart(messageBodyPart)

        val mailProperties = Properties()
        mailProperties["mail.smtp.host"]                    = host
        mailProperties["mail.smtp.port"]                    = "25"
        mailProperties["mail.debug"]                        = "false"
        mailProperties["mail.smtp.auth"]                    = "false"
        mailProperties["mail.smtp.socketFactory.class"]     = "javax.net.ssl.SSLSocketFactory"
        mailProperties["mail.smtp.socketFactory.fallback"]  = "true"

        val session = Session.getInstance(mailProperties)
        val message = MimeMessage(session)
        message.setFrom(from)
        message.addRecipient(Message.RecipientType.TO, InternetAddress(to.replace(" ", "").trim()))
        message.sentDate = Date()
        message.setContent(multipart)
        message.subject = subject

        Transport.send(message)
        return true
    }
}

