package com.invitation.service

import com.invitation.mappers.dto.EventDtoMapper
import com.invitation.mappers.dto.OwnerDtoMapper
import com.invitation.mappers.dto.ParticipantDtoMapper
import com.invitation.service.dto.AddParticipantRequest
import com.invitation.service.dto.CreateEventRequest
import com.invitation.service.dto.CreateOwnerRequest
import com.invitation.service.dto.GetEventResponse
import com.invitation.service.dto.GetOwnerResponse
import com.invitation.service.dto.GetParticipantResponse
import com.invitation.service.dto.UpdateParticipantInviteStatusRequest
import com.invitation.service.model.Event
import com.invitation.service.model.Owner
import com.invitation.service.model.Participant
import org.springframework.stereotype.Service

@Service
class InvitationService(
    private val ownerService: OwnerService,
    private val eventService: EventService,
    private val participantService: ParticipantService,
    private val ownerDtoMapper: OwnerDtoMapper,
    private val eventDtoMapper: EventDtoMapper,
    private val participantDtoMapper: ParticipantDtoMapper,
) {

    fun createOwner(createOwnerRequest: CreateOwnerRequest): Owner {
        var owner = ownerDtoMapper.map(createOwnerRequest)
        return ownerService.create(owner)
    }

    fun createEvent(createEventRequest: CreateEventRequest): Event {
        var event = eventDtoMapper.map(createEventRequest)
        return eventService.create(event)
    }

    fun addParticipant(addParticipantRequest: AddParticipantRequest): Participant {
        var participant = participantDtoMapper.map(addParticipantRequest)
        return participantService.create(participant)
    }

    fun getOwnerById(ownerId: Long): GetOwnerResponse {
        val owner = ownerService.getById(ownerId)
        val events = eventService.getByOwnerId(ownerId)
        return ownerDtoMapper.map(owner, events)
    }

    fun getEventById(eventId: Long): GetEventResponse {
        val event = eventService.getById(eventId)
        return eventDtoMapper.map(event)
    }

    fun getParticipantsByEventId(eventId: Long): List<GetParticipantResponse> {
        val participants = participantService.getByEventId(eventId)
        return participantDtoMapper.map(participants)
    }

    fun updateParticipantInviteStatus(updateParticipantStatusRequest: UpdateParticipantInviteStatusRequest): Participant {
        val updateParticipant = participantDtoMapper.map(updateParticipantStatusRequest)
        return participantService.updateInviteStatus(updateParticipant)
    }
}
