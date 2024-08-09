package ru.k2.outstaff.controllers

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import ru.k2.outstaff.dto.UserRoleDto
import ru.k2.outstaff.service.UserService

@Controller
@RequestMapping("/admin")
class AdminController(private val userService: UserService) {

    @GetMapping("/home")
    fun admin(): String {

        return "admin"
    }

    @GetMapping("/users")
    fun getUsers(model: Model): String{

        val all = userService.getAllUsersWithRoles()

        model.addAttribute("users", all)

        return "admin-user"
    }

    @GetMapping("/user/register")
    fun userRegisterForm(model: Model): String {
//        val roles = roleService.findRoles()

        model.addAttribute("roles", "roles")
        model.addAttribute("user", UserRoleDto())

        return "user-register"
    }

    @PostMapping("/user/register")
    fun userRegister(roleDto: UserRoleDto): String {

//        userRoleService.saveUser(roleDto)

        return "redirect:/admin/users"
    }

    @GetMapping("/roles")
    fun getRoles(model: Model): String{
//        val roles = roleService.findRoles()

        model.addAttribute("roles","roles" )

        return "admin-role"
    }

    @GetMapping("role/register")
    fun roleRegisterForm(model: Model): String{

//        model.addAttribute("role", RoleEntity())

        return "role-register"
    }

    @PostMapping("role/register")
    fun registerRole(): String{

//        roleService.saveRole(roleEntity)

        return "redirect:/admin/roles"
    }
}