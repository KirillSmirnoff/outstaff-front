package ru.k2.outstaff.persistence

import org.springframework.data.jpa.repository.JpaRepository
import ru.k2.outstaff.persistence.entity.UserRoleEntity

interface UsersRoleRepository: JpaRepository<UserRoleEntity, Long> {
}