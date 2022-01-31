package ru.k2.outstaff

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import ru.k2.outstaff.persistence.*
import ru.k2.outstaff.persistence.entity.RoleEntity
import ru.k2.outstaff.persistence.entity.UserEntity
import ru.k2.outstaff.persistence.entity.UserRoleEntity
import javax.transaction.Transactional

@SpringBootTest
class RepositoryTest
@Autowired constructor(val companyRepository: CompanyRepository,
                       val workerRepository: WorkerRepository,
                       val userRepository: UserRepository,
                       val roleRepository: RoleRepository,
                       val usersRoleRepository: UsersRoleRepository
) {

    @Test
    fun `test companyRepository`() {
        companyRepository.findAll().forEach { cmp -> println(cmp) }
    }

    @Test
    fun `test workerRepository`() {
        workerRepository.findAll().forEach { wrk -> println(wrk.companyId?.companyName) }
    }

    @Test
    fun `test company query`(){
        val company = companyRepository.findByName("SAID COMPANY")
        println(company.companyName +" - "+ company.id)
    }

    @Test
    fun `test user roles`(){
        val userEntity = UserEntity().apply {
            username = "Вован Петрович Жук"
            login = "wow"
            passsword = "0"
        }

        val roleEntity = RoleEntity().apply {
            roleName = "TEST"
        }

        userRepository.saveAndFlush(userEntity)
        roleRepository.saveAndFlush(roleEntity)



        val usersRoleEntity = UserRoleEntity().apply {
            user = userEntity
            role = roleEntity
        }
        usersRoleRepository.saveAndFlush(usersRoleEntity)
    }

    @Test
    @Transactional
    fun `find user by name`(){
        val user = userRepository.findByName("wow")

        val usersRole = user.userRole
        println(usersRole?.get(0)?.role?.roleName)

        Assertions.assertTrue("Вован Петрович Жук".equals(user.username))
    }
}