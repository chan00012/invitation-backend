package com.invitation.mappers.dto

import com.invitation.service.dto.CreateLocationRequest
import com.invitation.service.model.Location
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface LocationDtoMapper {

    fun map(createLocationRequest: CreateLocationRequest): Location
}
