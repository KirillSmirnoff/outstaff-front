package ru.k2.outstaff.persistence

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import ru.k2.outstaff.persistence.entity.UserEntity

interface UserRepository: JpaRepository<UserEntity, Long> {

    @Query("select u from UserEntity u LEFT JOIN fetch u.userRole where u.login = :name")
    fun findByName(@Param("name") name: String):UserEntity
}