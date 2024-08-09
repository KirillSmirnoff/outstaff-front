package ru.k2.outstaff.service

import org.springframework.stereotype.Service
import ru.k2.outstaff.dto.UserRoleDto

@Service
class UserService() {

    fun getAllUsersWithRoles(): MutableList<UserRoleDto> {
        val mutableList = mutableListOf<UserRoleDto>()
//        val users = userRepository.findAll()
       val users = listOf<UserRoleDto>()

        for (user in users){
            val userRoleDto = UserRoleDto().apply {
                id = user.id
//                userName = user.username
                login = user.login
                phone = user.phone
                mail = user.mail
//                roles = user.userRole!!.stream()
//                        .map { r -> r.role!!.roleName }
//                        .collect(Collectors.toList()) as List<String>?
            }
            mutableList.add(userRoleDto)
        }

        return mutableList
    }
}