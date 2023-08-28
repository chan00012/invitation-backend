package com.invitation.database.repository

import com.invitation.database.entity.JpaOwner
import org.springframework.data.jpa.repository.JpaRepository

interface OwnerRepository : JpaRepository<JpaOwner, Long>
