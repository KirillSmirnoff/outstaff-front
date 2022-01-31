package ru.k2.outstaff.persistence.entity

import javax.persistence.*

@Entity
@Table(name = "users_roles")
class UserRoleEntity (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "n_id")
    var id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "n_user_id")
    var user: UserEntity? = null,

    @ManyToOne
    @JoinColumn(name = "n_role_id")
    var role: RoleEntity? = null
) {

    fun setUsers(user: UserEntity?){
        this.user = user
        this.user?.userRole?.add(this)
    }

    fun setRoles(role: RoleEntity?){
        this.role = role
        this.role?.userRoles?.add(this)
    }
}