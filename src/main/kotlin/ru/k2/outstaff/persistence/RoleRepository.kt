package ru.k2.outstaff.persistence

import org.springframework.data.jpa.repository.JpaRepository
import ru.k2.outstaff.persistence.entity.RoleEntity

interface RoleRepository: JpaRepository<RoleEntity, Long> {
}