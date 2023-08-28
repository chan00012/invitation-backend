package com.invitation.database.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
@Table(name = "Events")
class JpaEvent(
    var name: String,
    var date: LocalDate,

    @Column(name = "start_date_time")
    var startDateTime: LocalDateTime,

    @Column(name = "end_date_time")
    var endDateTime: LocalDateTime,

    @ManyToOne
    @JoinColumn(name = "owner_id")
    var owner: JpaOwner?,

    @OneToMany(mappedBy = "event")
    var locations: Set<JpaLocation>? = mutableSetOf(),

    @OneToMany(mappedBy = "event")
    var participants: Set<JpaParticipant>? = mutableSetOf(),

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
)
