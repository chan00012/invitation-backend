package com.invitation.mappers.model

import com.invitation.database.entity.JpaLocation
import com.invitation.service.model.Location
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface LocationMapper {

    fun toModel(jpaLocation: JpaLocation): Location

    fun toEntity(location: Location): JpaLocation

    fun toEntity(locations: List<Location>): List<JpaLocation>
}
