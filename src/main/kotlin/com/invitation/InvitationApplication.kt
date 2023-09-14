package com.invitation

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class InvitationApplication

fun main(args: Array<String>) {
    runApplication<InvitationApplication>(*args)
}
