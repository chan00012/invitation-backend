package com.invitation.service.dto

import com.invitation.service.model.Owner

class GetOwnerResponse(
    id: Long? = null,
    name: String,
    var events: List<OwnerEventResponse>? = mutableListOf(),
) : Owner(id, name) {

    class OwnerEventResponse(
        var id: Long,
        var name: String,
    )
}
