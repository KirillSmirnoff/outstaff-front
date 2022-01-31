package ru.k2.outstaff.persistence.entity

import javax.persistence.*

@Entity
@Table(name = "users")
class UserEntity(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "n_id")
        var id:Long? = null,

        @Column(name = "c_username")
        var username: String? = null,

        @Column(name = "c_login")
        var login: String? = null,

        @Column(name = "c_password")
        var passsword: String? = null,

        @Column(name = "c_phone")
        var phone: String? = null,

        @Column(name = "c_mail")
        var mail: String? = null,

        @OneToMany(mappedBy = "user")
        var userRole: MutableList<UserRoleEntity>? = null

)