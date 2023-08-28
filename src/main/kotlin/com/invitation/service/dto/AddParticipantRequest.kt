package com.invitation.service.dto

import com.invitation.database.entity.ParticipantRole

data class AddParticipantRequest(
    var firstName: String,
    var middleInitial: Char? = null,
    var lastName: String,
    var role: ParticipantRole,
    var isVip: Boolean = false,
    var eventId: Long,
)
