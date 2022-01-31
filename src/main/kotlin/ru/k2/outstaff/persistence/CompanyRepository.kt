package ru.k2.outstaff.persistence

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import ru.k2.outstaff.persistence.entity.CompanyEntity

@Repository
interface CompanyRepository : JpaRepository<CompanyEntity, Int>{

    @Query("select c from CompanyEntity c where c.companyName = :companyName")
    fun findByName(@Param("companyName") companyName: String): CompanyEntity

}