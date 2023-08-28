package com.invitation.database.entity

import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "Locations")
class JpaLocation(
    @ManyToOne
    @JoinColumn(name = "event_id")
    var event: JpaEvent?,
    var name: String,
    var address: String,

    @Enumerated(EnumType.STRING)
    var type: LocationType,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
)
