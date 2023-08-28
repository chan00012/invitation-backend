package com.invitation.mappers.dto

import com.invitation.service.dto.CreateEventRequest
import com.invitation.service.dto.GetEventResponse
import com.invitation.service.model.Event
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface EventDtoMapper {

    fun map(createEventRequest: CreateEventRequest): Event

    fun map(event: Event): GetEventResponse
}
