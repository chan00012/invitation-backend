package com.invitation.service.dto

import com.invitation.database.entity.LocationType

data class CreateLocationRequest(
    var name: String,
    var address: String,
    var type: LocationType,
)
