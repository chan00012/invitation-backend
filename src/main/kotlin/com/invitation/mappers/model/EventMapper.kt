package com.invitation.mappers.model

import com.invitation.database.entity.JpaEvent
import com.invitation.service.model.Event
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(componentModel = "spring")
interface EventMapper {

    @Mapping(source = "owner.id", target = "ownerId")
    fun toModel(jpaEvent: JpaEvent): Event

    fun toModel(jpaEvents: List<JpaEvent>): List<Event>

    fun toEntity(event: Event): JpaEvent
}
