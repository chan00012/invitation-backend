package com.invitation.service.dto

import com.invitation.database.entity.InviteStatus
import com.invitation.database.entity.ParticipantRole
import java.time.LocalDateTime

data class GetParticipantResponse(
    val id: Long? = null,
    val firstName: String,
    val middleInitial: Char? = null,
    val lastName: String,
    val role: ParticipantRole,
    val contactNumber: String? = null,
    val email: String? = null,
    val isVip: Boolean = false,
    val inviteStatus: InviteStatus,
    val tableNumber: Int? = null,
    val lastUpdate: LocalDateTime? = null,
    val code: String? = null,
)
