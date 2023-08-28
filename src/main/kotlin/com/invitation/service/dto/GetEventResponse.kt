package com.invitation.service.dto

import com.invitation.service.model.Location
import java.time.LocalDate
import java.time.LocalDateTime

class GetEventResponse(
    var id: Long? = null,
    var name: String,
    var date: LocalDate,
    var startDateTime: LocalDateTime,
    var endDateTime: LocalDateTime,
    var locations: List<Location>? = mutableListOf(),
)
