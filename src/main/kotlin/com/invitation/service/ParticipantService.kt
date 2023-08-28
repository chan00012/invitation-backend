package com.invitation.service

import com.invitation.database.repository.EventRepository
import com.invitation.database.repository.ParticipantRepository
import com.invitation.mappers.model.ParticipantMapper
import com.invitation.service.model.Participant
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class ParticipantService(
    private val participantRepository: ParticipantRepository,
    private val eventRepository: EventRepository,
    private val participantMapper: ParticipantMapper,
) {

    fun create(participant: Participant): Participant {
        val event = eventRepository.findById(participant.eventId!!)
        val jpaParticipant = participantMapper.toEntity(participant)
        jpaParticipant.event = event.get()
        jpaParticipant.code = generateParticipantCode()

        val savedJpaParticipant = participantRepository.save(jpaParticipant)
        return participantMapper.toModel(savedJpaParticipant)
    }

    fun updateInviteStatus(participant: Participant): Participant {
        var existingJpaParticipant = participantRepository.findById(participant.id!!).get()
        existingJpaParticipant.inviteStatus = participant.inviteStatus
        existingJpaParticipant.contactNumber = participant.contactNumber
        existingJpaParticipant.email = participant.email
        existingJpaParticipant.lastUpdate = LocalDateTime.now()

        participantRepository.save(existingJpaParticipant)
        return participantMapper.toModel(existingJpaParticipant)
    }

    fun getByEventId(eventId: Long): List<Participant> {
        val jpaParticipants = participantRepository.findByEventId(eventId)
        return participantMapper.toModel(jpaParticipants)
    }

    private fun generateParticipantCode(): String {
        val allowedChars = ('A'..'Z') + ('0'..'9')
        return (1..6)
            .map { allowedChars.random() }
            .joinToString("")
    }
}
