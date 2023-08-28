package com.invitation.service

import com.invitation.database.repository.EventRepository
import com.invitation.database.repository.LocationRepository
import com.invitation.database.repository.OwnerRepository
import com.invitation.mappers.model.EventMapper
import com.invitation.mappers.model.LocationMapper
import com.invitation.service.model.Event
import org.springframework.stereotype.Service

@Service
class EventService(
    private val eventRepository: EventRepository,
    private val ownerRepository: OwnerRepository,
    private val locationRepository: LocationRepository,
    private val locationMapper: LocationMapper,
    private val eventMapper: EventMapper,
) {

    fun create(event: Event): Event {
        var jpaOwner = ownerRepository.findById(event.ownerId)
        val jpaEvent = eventMapper.toEntity(event)
        val jpaLocations = locationMapper.toEntity(event.locations!!)

        jpaLocations.forEach { location -> location.event = jpaEvent }
        jpaEvent.owner = jpaOwner.get()
        jpaEvent.locations = jpaLocations.toSet()

        val savedJpaEvent = eventRepository.save(jpaEvent)
        locationRepository.saveAll(jpaLocations)

        return eventMapper.toModel(savedJpaEvent)
    }

    fun getById(id: Long): Event {
        val jpaEvent = eventRepository.findById(id)
        return eventMapper.toModel(jpaEvent.get())
    }

    fun getByOwnerId(ownerId: Long): List<Event> {
        val jpaEvents = eventRepository.findByOwnerId(ownerId)
        return eventMapper.toModel(jpaEvents)
    }
}
