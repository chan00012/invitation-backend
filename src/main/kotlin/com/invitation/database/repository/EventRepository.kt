package com.invitation.database.repository

import com.invitation.database.entity.JpaEvent
import org.springframework.data.jpa.repository.JpaRepository

interface EventRepository : JpaRepository<JpaEvent, Long> {

    fun findByOwnerId(id: Long): List<JpaEvent>
}
