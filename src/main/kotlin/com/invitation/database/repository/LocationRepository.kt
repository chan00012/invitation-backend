package com.invitation.database.repository

import com.invitation.database.entity.JpaLocation
import org.springframework.data.jpa.repository.JpaRepository

interface LocationRepository : JpaRepository<JpaLocation, Long>
