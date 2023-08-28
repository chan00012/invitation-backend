package com.invitation.mappers.model

import com.invitation.database.entity.JpaOwner
import com.invitation.service.model.Owner
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface OwnerMapper {

    fun toModel(jpaOwner: JpaOwner): Owner

    fun toEntity(owner: Owner): JpaOwner
}
