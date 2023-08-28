package com.invitation.service.model

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDate
import java.time.LocalDateTime

open class Event(
    var id: Long? = null,
    var ownerId: Long,
    var name: String,

    @JsonFormat(pattern = "MM-dd-yyyy")
    var date: LocalDate,

    @JsonFormat(pattern = "MM-dd-yyyy HH:mm:ss")
    var startDateTime: LocalDateTime,

    @JsonFormat(pattern = "MM-dd-yyyy HH:mm:ss")
    var endDateTime: LocalDateTime,
    var locations: List<Location>? = mutableListOf(),
)
