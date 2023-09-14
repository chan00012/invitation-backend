package com.invitation.service.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.invitation.database.entity.InviteStatus
import com.invitation.database.entity.ParticipantRole
import java.time.LocalDateTime

open class Participant(
    var id: Long? = null,
    var eventId: Long,
    var firstName: String,
    var middleInitial: Char? = null,
    var lastName: String,
    var role: ParticipantRole? = null,
    var contactNumber: String? = null,
    var email: String? = null,
    var isVip: Boolean = false,
    var inviteStatus: InviteStatus? = null,
    var tableNumber: Int? = null,

    @JsonFormat(pattern = "MM-dd-yyyy HH:mm:ss")
    var lastUpdate: LocalDateTime? = null,
    var code: String? = null,
) {
    fun fullname(): String {
        return "${this.firstName} ${this.lastName}"
    }
}
