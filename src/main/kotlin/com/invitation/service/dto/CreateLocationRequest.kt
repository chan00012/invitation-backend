package com.invitation.service.dto

import com.invitation.database.entity.LocationType

data class CreateLocationRequest(
    val name: String,
    val address: String,
    val type: LocationType,
)
