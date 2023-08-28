package com.invitation.mappers.dto

import com.invitation.service.dto.CreateOwnerRequest
import com.invitation.service.dto.GetOwnerResponse
import com.invitation.service.model.Event
import com.invitation.service.model.Owner
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface OwnerDtoMapper {

    fun map(createOwnerRequest: CreateOwnerRequest): Owner

    fun map(owner: Owner, events: List<Event>): GetOwnerResponse
}
