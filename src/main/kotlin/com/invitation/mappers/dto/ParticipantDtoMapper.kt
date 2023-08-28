package com.invitation.mappers.dto

import com.invitation.service.dto.AddParticipantRequest
import com.invitation.service.dto.GetParticipantResponse
import com.invitation.service.dto.UpdateParticipantInviteStatusRequest
import com.invitation.service.model.Participant
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(componentModel = "spring")
interface ParticipantDtoMapper {

    @Mapping(target = "inviteStatus", constant = "PENDING")
    fun map(addParticipantRequest: AddParticipantRequest): Participant

    fun map(participant: Participant): GetParticipantResponse

    fun map(participants: List<Participant>): List<GetParticipantResponse>

    @Mapping(source = "participantId", target = "id")
    @Mapping(target = "firstName", constant = "")
    @Mapping(target = "lastName", constant = "")
    @Mapping(target = "role", constant = "GUEST")
    fun map(updateParticipantStatusRequest: UpdateParticipantInviteStatusRequest): Participant
}
