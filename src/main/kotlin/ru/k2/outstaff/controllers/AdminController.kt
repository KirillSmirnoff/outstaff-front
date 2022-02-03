package ru.k2.outstaff.controllers

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import ru.k2.outstaff.persistence.RoleRepository
import ru.k2.outstaff.persistence.UserRepository
import ru.k2.outstaff.persistence.dto.UserRoleDto
import ru.k2.outstaff.service.RoleService
import ru.k2.outstaff.service.UserRoleService
import ru.k2.outstaff.service.UserService

@Controller
@RequestMapping("/admin")
class AdminController(private val userRepository: UserRepository,
                      private val roleRepository: RoleRepository,
                      private val roleService: RoleService,
                      private val userService: UserService,
                      private val userRoleService: UserRoleService) {

    @GetMapping("/home")
    fun admin(): String {

//        val all = userRepository.findAll()
//        val all = userService.getAllUsersWithRoles()

//        model.addAttribute("users", all)

        return "admin"
    }

    @GetMapping("/users")
    fun getUsers(model: Model): String{

//        val all = userRepository.findAll()
        val all = userService.getAllUsersWithRoles()

        model.addAttribute("users", all)

        return "admin-user"
    }

    @GetMapping("/user/register")
    fun userRegisterForm(model: Model): String {
        val roles = roleRepository.findAll()

        model.addAttribute("roles", roles)
        model.addAttribute("user", UserRoleDto())

        return "user-register"
    }

    @PostMapping("/user/register")
    fun userRegister(roleDto: UserRoleDto): String {

        userRoleService.saveUser(roleDto)

        return "redirect:/admin/home"
    }

    @GetMapping("/roles")
    fun roleRegisterForm(model: Model): String{
        val roles = roleService.findRoles()

        model.addAttribute("roles",roles )

        return "admin-role"
    }
}