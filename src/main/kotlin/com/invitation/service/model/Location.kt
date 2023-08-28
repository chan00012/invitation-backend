package com.invitation.service.model

import com.invitation.database.entity.LocationType

open class Location(
    var id: Long? = null,
    var name: String,
    var address: String,
    var type: LocationType,
)
