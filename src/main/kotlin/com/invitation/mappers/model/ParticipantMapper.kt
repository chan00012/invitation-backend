package com.invitation.mappers.model

import com.invitation.database.entity.JpaParticipant
import com.invitation.service.model.Participant
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(componentModel = "spring")
interface ParticipantMapper {

    @Mapping(source = "event.id", target = "eventId")
    fun toModel(jpaParticipant: JpaParticipant): Participant

    fun toModel(jpaParticipants: List<JpaParticipant>): List<Participant>

    fun toEntity(participant: Participant): JpaParticipant
}
