package ru.k2.outstaff.service

import org.springframework.stereotype.Service
import ru.k2.outstaff.persistence.RoleRepository
import ru.k2.outstaff.persistence.entity.RoleEntity

@Service
class RoleService(private val roleRepository: RoleRepository) {

    fun findRoles(): MutableList<RoleEntity> = roleRepository.findAll()
}