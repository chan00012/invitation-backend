package com.invitation.database.repository

import com.invitation.database.entity.JpaParticipant
import org.springframework.data.jpa.repository.JpaRepository

interface ParticipantRepository : JpaRepository<JpaParticipant, Long> {

    fun findByEventId(id: Long): List<JpaParticipant>
}
