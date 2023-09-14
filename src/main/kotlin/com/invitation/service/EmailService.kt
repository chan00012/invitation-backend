package com.invitation.service

import com.sendgrid.Method
import com.sendgrid.Request
import com.sendgrid.SendGrid
import com.sendgrid.helpers.mail.Mail
import com.sendgrid.helpers.mail.objects.Content
import com.sendgrid.helpers.mail.objects.Email
import com.sendgrid.helpers.mail.objects.Personalization
import mu.KotlinLogging
import org.springframework.stereotype.Service

@Service
class EmailService(
    private val config: EmailConfiguration,
    private val sendGrid: SendGrid,
) {
    private val logger = KotlinLogging.logger {}

    fun sendConfirmationEmail(to: String, dynamicTemplateData: Map<String, Any>) {
        try {
            val fromMail = Email(config.from, "Christian and Angeli")
            val subject = "Thanks for your confirmation"
            var toEmail = Email(to)
            val content = Content("text/html", " ")

            var personalization = Personalization()
            personalization.addTo(toEmail)
            dynamicTemplateData.forEach { (key, value) -> personalization.addDynamicTemplateData(key, value) }

            var mail = Mail(fromMail, subject, toEmail, content)
            mail.templateId = config.confirmationTemplateId
            mail.personalization = listOf(personalization)

            var request = Request()
            request.method = Method.POST
            request.endpoint = "mail/send"
            request.body = mail.build()

            logger.info { "Sending confirmation email to: $to customizationData: ${personalization.dynamicTemplateData}" }
            sendGrid.api(request)
        } catch (e: Exception) {
            logger.error { "Error occurred when sending email. ${e.message}" }
        }
    }
}
