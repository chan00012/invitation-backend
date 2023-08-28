package com.invitation.service.dto

import com.invitation.database.entity.InviteStatus
import com.invitation.database.entity.ParticipantRole
import java.time.LocalDateTime

class GetParticipantResponse(
    var id: Long? = null,
    var firstName: String,
    var middleInitial: Char? = null,
    var lastName: String,
    var role: ParticipantRole,
    var contactNumber: String? = null,
    var email: String? = null,
    var isVip: Boolean = false,
    var inviteStatus: InviteStatus,
    var tableNumber: Int? = null,
    var lastUpdate: LocalDateTime? = null,
    var code: String? = null,
)
