package com.invitation.service.dto

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDate
import java.time.LocalDateTime

data class CreateEventRequest(
    var name: String,
    var date: LocalDate,

    @JsonFormat(pattern = "MM-dd-yyyy HH:mm:ss")
    var startDateTime: LocalDateTime,

    @JsonFormat(pattern = "MM-dd-yyyy HH:mm:ss")
    var endDateTime: LocalDateTime,
    var locations: List<CreateLocationRequest>,
    var ownerId: Long,
)
