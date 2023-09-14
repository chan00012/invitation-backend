package com.invitation.service.dto

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDate
import java.time.LocalDateTime

data class CreateEventRequest(
    val name: String,
    val date: LocalDate,

    @JsonFormat(pattern = "MM-dd-yyyy HH:mm:ss")
    val startDateTime: LocalDateTime,

    @JsonFormat(pattern = "MM-dd-yyyy HH:mm:ss")
    val endDateTime: LocalDateTime,
    val locations: List<CreateLocationRequest>,
    val ownerId: Long,
)
