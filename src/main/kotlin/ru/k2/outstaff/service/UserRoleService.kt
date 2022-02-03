package ru.k2.outstaff.service

import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import ru.k2.outstaff.persistence.RoleRepository
import ru.k2.outstaff.persistence.UserRepository
import ru.k2.outstaff.persistence.UsersRoleRepository
import ru.k2.outstaff.persistence.dto.UserRoleDto
import ru.k2.outstaff.persistence.entity.UserEntity
import ru.k2.outstaff.persistence.entity.UserRoleEntity

@Service
class UserRoleService(private val usersRoleRepository: UsersRoleRepository,
                      private val passwordEncoder: PasswordEncoder,
                      private val roleRepository: RoleRepository,
                      private val userRepository: UserRepository) {

    fun saveUser(userRoleDto: UserRoleDto) {
        val userEntity = UserEntity().apply {
            username = userRoleDto.userName
            login = userRoleDto.login
            passsword = passwordEncoder.encode(userRoleDto.password)
            phone = userRoleDto.phone
            mail = userRoleDto.mail
        }

        userRepository.saveAndFlush(userEntity)


        val roles = roleRepository.findByName(userRoleDto.roles!!)

        if (!roles.isNullOrEmpty()) {
            for (curRole in roles) {
                val userRole = UserRoleEntity().apply {
                    user = userEntity
                    role = curRole
                }

                usersRoleRepository.saveAndFlush(userRole)
            }
        }

    }
}