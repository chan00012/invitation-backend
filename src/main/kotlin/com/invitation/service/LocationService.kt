package com.invitation.service

import com.invitation.database.entity.JpaLocation
import com.invitation.database.repository.LocationRepository
import org.springframework.stereotype.Service

@Service
class LocationService(
    private val locationRepository: LocationRepository,
) {
    fun create(location: JpaLocation) {
        locationRepository.save(location)
    }
}
