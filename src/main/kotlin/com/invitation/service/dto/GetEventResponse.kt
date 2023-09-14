package com.invitation.service.dto

import com.invitation.service.model.Location
import java.time.LocalDate
import java.time.LocalDateTime

data class GetEventResponse(
    val id: Long? = null,
    val name: String,
    val date: LocalDate,
    val startDateTime: LocalDateTime,
    val endDateTime: LocalDateTime,
    val locations: List<Location>? = mutableListOf(),
)
