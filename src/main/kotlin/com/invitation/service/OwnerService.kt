package com.invitation.service

import com.invitation.database.repository.OwnerRepository
import com.invitation.mappers.model.OwnerMapper
import com.invitation.service.model.Owner
import org.springframework.stereotype.Service

@Service
class OwnerService(
    private val ownerRepository: OwnerRepository,
    private val ownerMapper: OwnerMapper,
) {
    fun create(owner: Owner): Owner {
        val jpaOwner = ownerMapper.toEntity(owner)
        val savedJpaOwner = ownerRepository.save(jpaOwner)
        return ownerMapper.toModel(savedJpaOwner)
    }

    fun getById(id: Long): Owner {
        val jpaOwner = ownerRepository.findById(id)
        return ownerMapper.toModel(jpaOwner.get())
    }
}
