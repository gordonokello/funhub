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

    fun secretSantaTemplate(
        giver: String,
        recipient: String,
    ): String {
        return """
            <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
            <html data-editor-version="2" class="sg-campaigns" xmlns="http://www.w3.org/1999/xhtml">
            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
                <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1"/>
                <!--[if !mso]><!-->
                <meta http-equiv="X-UA-Compatible" content="IE=Edge"/><!--<![endif]-->     <!--[if (gte mso 9)|(IE)]>
                <xml>
                    <o:OfficeDocumentSettings>
                        <o:AllowPNG/>
                        <o:PixelsPerInch>96</o:PixelsPerInch>
                    </o:OfficeDocumentSettings>
                </xml>     <![endif]-->     <!--[if (gte mso 9)|(IE)]>
                <style type="text/css">       body {
                    width: 600px;
                    margin: 0 auto;
                }

                table {
                    border-collapse: collapse;
                }

                table, td {
                    mso-table-lspace: 0pt;
                    mso-table-rspace: 0pt;
                }

                img {
                    -ms-interpolation-mode: bicubic;
                }     </style>     <![endif]-->
                <style type="text/css">       body, p, div {
                    font-family: arial;
                    font-size: 14px;
                }

                body {
                    color: #000000;
                }

                body a {
                    color: #1188E6;
                    text-decoration: none;
                }

                p {
                    margin: 0;
                    padding: 0;
                }

                table.wrapper {
                    width: 100% !important;
                    table-layout: fixed;
                    -webkit-font-smoothing: antialiased;
                    -webkit-text-size-adjust: 100%;
                    -moz-text-size-adjust: 100%;
                    -ms-text-size-adjust: 100%;
                }

                img.max-width {
                    max-width: 100% !important;
                }

                .column.of-2 {
                    width: 50%;
                }

                .column.of-3 {
                    width: 33.333%;
                }

                .column.of-4 {
                    width: 25%;
                }

                @media screen and (max-width: 480px) {
                    .preheader .rightColumnContent, .footer .rightColumnContent {
                        text-align: left !important;
                    }

                    .preheader .rightColumnContent div, .preheader .rightColumnContent span, .footer .rightColumnContent div, .footer .rightColumnContent span {
                        text-align: left !important;
                    }

                    .preheader .rightColumnContent, .preheader .leftColumnContent {
                        font-size: 80% !important;
                        padding: 5px 0;
                    }

                    table.wrapper-mobile {
                        width: 100% !important;
                        table-layout: fixed;
                    }

                    img.max-width {
                        height: auto !important;
                        max-width: 480px !important;
                    }

                    a.bulletproof-button {
                        display: block !important;
                        width: auto !important;
                        font-size: 80%;
                        padding-left: 0 !important;
                        padding-right: 0 !important;
                    }

                    .columns {
                        width: 100% !important;
                    }

                    .column {
                        display: block !important;
                        width: 100% !important;
                        padding-left: 0 !important;
                        padding-right: 0 !important;
                        margin-left: 0 !important;
                        margin-right: 0 !important;
                    }
                }     </style>     <!--user entered Head Start-->          <!--End Head user entered-->   </head>
            <body>
            <center class="wrapper" data-link-color="#1188E6"
                    data-body-style="font-size: 14px; font-family: arial; color: #000000; background-color: #f2f2f2;">
                <div class="webkit">
                    <table cellpadding="0" cellspacing="0" border="0" width="100%" class="wrapper" bgcolor="#f2f2f2">
                        <tr>
                            <td valign="top" bgcolor="#f2f2f2" width="100%">
                                <table width="100%" role="content-container" class="outer" align="center" cellpadding="0"
                                       cellspacing="0" border="0">
                                    <tr>
                                        <td width="100%">
                                            <table width="100%" cellpadding="0" cellspacing="0" border="0">
                                                <tr>
                                                    <td>                           <!--[if mso]>
                                                        <center>
                                                            <table>
                                                                <tr>
                                                                    <td width="600">                           <![endif]-->
                                                        <table width="100%" cellpadding="0" cellspacing="0" border="0"
                                                               style="width: 100%; max-width:600px;" align="center">
                                                            <tr>
                                                                <td role="modules-container"
                                                                    style="padding: 0px 0px 0px 0px; color: #000000; text-align: left;"
                                                                    bgcolor="#ffffff" width="100%" align="left">
                                                                    <table class="module preheader preheader-hide" role="module"
                                                                           data-type="preheader" border="0" cellpadding="0"
                                                                           cellspacing="0" width="100%"
                                                                           style="display: none !important; mso-hide: all; visibility: hidden; opacity: 0; color: transparent; height: 0; width: 0;">
                                                                        <tr>
                                                                            <td role="module-content"><p></p></td>
                                                                        </tr>
                                                                    </table>
                                                                    <table class="module" role="module" data-type="spacer"
                                                                           border="0" cellpadding="0" cellspacing="0" width="100%"
                                                                           style="table-layout: fixed;">
                                                                        <tr>
                                                                            <td style="padding:0px 0px 50px 0px;"
                                                                                role="module-content" bgcolor="#f2f2f2"></td>
                                                                        </tr>
                                                                    </table>
                                                                    <table class="wrapper" role="module" data-type="image"
                                                                           border="0" cellpadding="0" cellspacing="0" width="100%"
                                                                           style="table-layout: fixed;">
                                                                        <tr>
                                                                            <td style="font-size:6px;line-height:10px;padding:0px 0px 0px 0px;"
                                                                                valign="top" align="center"><img class="max-width"
                                                                                                                 style="display:block;color:#000000;text-decoration:none;font-family:Helvetica, arial, sans-serif;font-size:16px;max-width:100% !important;width:100%;height:auto !important;"
                                                                                                                 src="cid:image"
                                                                                                                 alt="" width="600"
                                                                                                                 border="0"></td>
                                                                        </tr>
                                                                    </table>
                                                                    <table class="wrapper" role="module" data-type="image"
                                                                           border="0" cellpadding="0" cellspacing="0" width="100%"
                                                                           style="table-layout: fixed;">
                                                                        <tr>
                                                                            <td style="font-size:6px;line-height:10px;padding:0px 0px 0px 0px;"
                                                                                valign="top" align="center"></td>
                                                                        </tr>
                                                                    </table>
                                                                    <table class="module" role="module" data-type="text" border="0"
                                                                           cellpadding="0" cellspacing="0" width="100%"
                                                                           style="table-layout: fixed;">
                                                                        <tr>
                                                                            <td style="padding:20px 48px 020px 48px;line-height:22px;text-align:justify;"
                                                                                height="100%" valign="top" bgcolor="">
                                                                                <div><span
                                                                                        style="font-family:verdana,geneva,sans-serif;"><strong>Your Secret Santa Assignment Is Here!</strong></span>
                                                                                </div>
                                                                                <div>&nbsp;</div>
                                                                                <div>
                                                                                    <div>
                                                                                        <div>
                                                                                            <div><span
                                                                                                    style="font-family:verdana,geneva,sans-serif;">Hi <strong>${giver}</strong>,</span>
                                                                                            </div>
                                                                                            <div>&nbsp;</div>
                                                                                            <div><span
                                                                                                    style="font-family:verdana,geneva,sans-serif;">It is that magical time of year again, and you have officially been assigned your Secret Santa recipient!</span>
                                                                                            </div>
                                                                                            <div>&nbsp;</div>
                                                                                            <div><span
                                                                                                    style="font-family:verdana,geneva,sans-serif;">You will be gifting to<strong>: ${recipient}</strong></span>
                                                                                            </div>
                                                                                            <div>&nbsp;</div>
                                                                                            <div><span
                                                                                                    style="font-family:verdana,geneva,sans-serif;">Here are a few tips to make it special:</span>
                                                                                            </div>
                                                                                            <div>
                                                                                                <ul style="font-family:verdana,geneva,sans-serif;">
                                                                                                    <li>Keep it anonymous until the big reveal!</li>
                                                                                                    <li>Aim for something thoughtful and fun.</li>
                                                                                                    <li>Suggested budget: KES 2,000 MAX</li>
                                                                                                </ul>
                                                                                            </div>
                                                                                            <div></div>
                                                                                            <div><span
                                                                                                    style="font-family:verdana,geneva,sans-serif;">Need ideas? Think hobbies, favorite snacks, cozy items, or something handmade.</span>
                                                                                            </div>
                                                                                            <div></div>
                                                                                            <div>&nbsp;</div>
                                                                                            <div><span
                                                                                                    style="font-family:verdana,geneva,sans-serif;">Gift exchange date: Friday, 5th December 2025 </span>
                                                                                            </div>
                                                                                            <div><span
                                                                                                    style="font-family:verdana,geneva,sans-serif;">Location: iCube </span>
                                                                                            </div>
                                                                                            <div>&nbsp;</div>
                                                                                            <div><span
                                                                                                    style="font-family:verdana,geneva,sans-serif;">If you have any questions or need help, feel free to reach out.</span>
                                                                                            </div>
                                                                                            <div>&nbsp;</div>
                                                                                            <div><span
                                                                                                    style="font-family:verdana,geneva,sans-serif;">Yours funfully, with mystery and mischief,</span>
                                                                                            </div>
                                                                                            <div><span
                                                                                                    style="font-family:verdana,geneva,sans-serif;"><strong>FunHub Crew</strong></span>
                                                                                            </div>
                                                                                        </div>
                                                                                    </div>
                                                                                </div>
                                                                            </td>
                                                                        </tr>
                                                                    </table>
                                                                    <table class="module" role="module" data-type="divider"
                                                                           border="0" cellpadding="0" cellspacing="0" width="100%"
                                                                           style="table-layout: fixed;">
                                                                        <tr>
                                                                            <td style="padding:0px 0px 0px 0px;"
                                                                                role="module-content" height="100%" valign="top"
                                                                                bgcolor="">
                                                                                <table border="0" cellpadding="0" cellspacing="0"
                                                                                       align="center" width="100%" height="2px"
                                                                                       style="line-height:2px; font-size:2px;">
                                                                                    <tr>
                                                                                        <td style="padding: 0px 0px 2px 0px;"
                                                                                            bgcolor="#000000"></td>
                                                                                    </tr>
                                                                                </table>
                                                                            </td>
                                                                        </tr>
                                                                    </table>
                                                                    <table class="module" role="module" data-type="text" border="0"
                                                                           cellpadding="0" cellspacing="0" width="100%"
                                                                           style="table-layout: fixed;">
                                                                        <tr>
                                                                            <td style="padding:10px 48px 10px 48px;line-height:18px;text-align:justify;"
                                                                                height="100%" valign="top" bgcolor="">
                                                                                <div style="text-align: center;"><span
                                                                                        style="font-size:12px;"><em><span
                                                                                        style="font-family:verdana,geneva,sans-serif;">Building culture one byte at a time</span></em></span>
                                                                                </div>
                                                                            </td>
                                                                        </tr>
                                                                    </table>
                                                                    <table class="module" role="module" data-type="divider"
                                                                           border="0" cellpadding="0" cellspacing="0" width="100%"
                                                                           style="table-layout: fixed;">
                                                                        <tr>
                                                                            <td style="padding:0px 0px 0px 0px;"
                                                                                role="module-content" height="100%" valign="top"
                                                                                bgcolor="">
                                                                                <table border="0" cellpadding="0" cellspacing="0"
                                                                                       align="center" width="100%" height="2px"
                                                                                       style="line-height:2px; font-size:2px;">
                                                                                    <tr>
                                                                                        <td style="padding: 0px 0px 2px 0px;"
                                                                                            bgcolor="#000000"></td>
                                                                                    </tr>
                                                                                </table>
                                                                            </td>
                                                                        </tr>
                                                                    </table>
                                                                </td>
                                                            </tr>
                                                        </table>
                                                        <!--[if mso]>                           </td></tr></table>                           </center>
                                                        <![endif]-->                         </td>
                                                </tr>
                                            </table>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                    </table>
                </div>
            </center>
            </body>
            </html>
    """.trimIndent()
    }


    fun sendMail(host: String, from: String, to: String, subject: String, htmlText: String, imagePath: String): Boolean {
        val defaultBanner = FileSystemResource(imagePath.plus("/images/banner.jpg")).file
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

