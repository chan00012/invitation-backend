package com.invitation.controller

import com.invitation.database.entity.InviteStatus
import com.invitation.service.InvitationService
import com.invitation.service.dto.AddParticipantRequest
import com.invitation.service.dto.CreateEventRequest
import com.invitation.service.dto.CreateOwnerRequest
import com.invitation.service.dto.GetEventResponse
import com.invitation.service.dto.GetOwnerResponse
import com.invitation.service.dto.GetParticipantResponse
import com.invitation.service.dto.ResponseWrapper
import com.invitation.service.dto.UpdateParticipantInviteStatusRequest
import com.invitation.service.model.Event
import com.invitation.service.model.Owner
import com.invitation.service.model.Participant
import mu.KotlinLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/invitation")
class InvitationController(
    val invitationService: InvitationService,
) {
    private val logger = KotlinLogging.logger {}

    @PostMapping("/owner")
    fun createOwner(@RequestBody createOwnerRequest: CreateOwnerRequest): Owner {
        logger.info { "Creating owner" }
        return invitationService.createOwner(createOwnerRequest)
    }

    @PostMapping("/event")
    fun createEvent(@RequestBody createEventRequest: CreateEventRequest): Event {
        logger.info { "creating event for owner id: ${createEventRequest.ownerId}" }
        return invitationService.createEvent(createEventRequest)
    }

    @PostMapping("/participant")
    fun addParticipant(@RequestBody addParticipantRequest: AddParticipantRequest): Participant {
        logger.info { "adding participant on event id: ${addParticipantRequest.eventId}" }
        return invitationService.addParticipant(addParticipantRequest)
    }

    @GetMapping("owner/{ownerId}")
    fun getOwnerById(@PathVariable ownerId: Long): GetOwnerResponse {
        logger.info { "fetching owner id: $ownerId" }
        return invitationService.getOwnerById(ownerId)
    }

    @GetMapping("event/{eventId}")
    fun getEventById(@PathVariable eventId: Long): GetEventResponse {
        logger.info { "fetching event id: $eventId" }
        return invitationService.getEventById(eventId)
    }

    @GetMapping("/participants")
    fun getParticipantsByEventId(@RequestParam eventId: Long): List<GetParticipantResponse> {
        logger.info { "fetching participants of event id: $eventId" }
        return invitationService.getParticipantsByEventId(eventId)
    }

    @PatchMapping("/participant")
    fun updateParticipantInviteStatus(@RequestBody updateParticipantStatusRequest: UpdateParticipantInviteStatusRequest): ResponseWrapper<InviteStatus> {
        logger.info { "updating invite status of participant id: ${updateParticipantStatusRequest.participantId}" }
        val result = invitationService.updateParticipantInviteStatus(updateParticipantStatusRequest)
        return ResponseWrapper(result)
    }
}
