package com.invitation.service.dto

import com.invitation.database.entity.ParticipantRole

data class AddParticipantRequest(
    val firstName: String,
    val middleInitial: Char? = null,
    val lastName: String,
    val role: ParticipantRole,
    val isVip: Boolean = false,
    val eventId: Long,
)
