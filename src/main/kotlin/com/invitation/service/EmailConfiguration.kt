package com.invitation.service

import com.sendgrid.SendGrid
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean

@ConfigurationProperties(prefix = "send-grid")
class EmailConfiguration(
    private val apiKey: String,
    val from: String,
    val confirmationTemplateId: String,
) {

    @Bean
    fun sendGrid(): SendGrid {
        return SendGrid(this.apiKey)
    }
}
