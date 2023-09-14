package com.invitation.service.dto

import com.invitation.service.model.Owner

class GetOwnerResponse(
    id: Long? = null,
    name: String,
    val events: List<OwnerEventResponse>? = mutableListOf(),
) : Owner(id, name) {

    class OwnerEventResponse(
        val id: Long,
        val name: String,
    )
}
