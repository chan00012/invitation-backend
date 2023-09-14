package com.invitation.database.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "Participants")
class JpaParticipant(
    @ManyToOne
    @JoinColumn(name = "event_id")
    var event: JpaEvent? = null,

    @Column(name = "first_name")
    var firstName: String,

    @Column(name = "middle_initial")
    var middleInitial: Char? = null,

    @Column(name = "last_name")
    var lastName: String,

    @Enumerated(EnumType.STRING)
    var role: ParticipantRole = ParticipantRole.GUEST,

    @Column(name = "contact_number")
    var contactNumber: String? = null,
    var email: String? = null,

    @Column(name = "is_vip")
    var isVip: Boolean = false,

    @Enumerated(EnumType.STRING)
    @Column(name = "invite_status")
    var inviteStatus: InviteStatus = InviteStatus.PENDING,

    @Column(name = "table_number")
    var tableNumber: Int? = null,

    @Column(name = "last_update")
    var lastUpdate: LocalDateTime? = null,
    var code: String? = null,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
)
