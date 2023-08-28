package com.invitation.service.dto

import com.invitation.database.entity.InviteStatus

class UpdateParticipantInviteStatusRequest(
    var participantId: Long,
    var contactNumber: String,
    var email: String,
    var inviteStatus: InviteStatus,
)
