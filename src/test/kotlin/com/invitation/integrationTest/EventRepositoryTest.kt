package com.invitation.integrationTest

import com.invitation.database.repository.EventRepository
import com.invitation.database.repository.LocationRepository
import com.invitation.database.repository.OwnerRepository
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@DataJpaTest
@AutoConfigureTestDatabase
class EventRepositoryTest {

    @Autowired
    private lateinit var ownerRepository: OwnerRepository

    @Autowired
    private lateinit var eventRepository: EventRepository

    @Autowired
    private lateinit var locationRepository: LocationRepository
}
