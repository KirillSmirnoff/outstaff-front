package ru.k2.outstaff.controllers

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import ru.k2.outstaff.persistence.RoleRepository
import ru.k2.outstaff.persistence.UserRepository
import ru.k2.outstaff.persistence.dto.UserRoleDto
import ru.k2.outstaff.persistence.entity.UserEntity
import ru.k2.outstaff.persistence.entity.UserRoleEntity

@Controller
@RequestMapping("/admin")
class AdminController(private val userRepository: UserRepository,
                      private val roleRepository: RoleRepository ) {

    @GetMapping("/home")
    fun admin(model: Model): String{

        val all = userRepository.findAll()

        model.addAttribute("users",all)

        return "admin"
    }

    @GetMapping("/user/register")
    fun registerForm(model: Model): String{
        val roles = roleRepository.findAll()

        model.addAttribute("roles" , roles)
        model.addAttribute("user", UserRoleDto())

        return "user-register"
    }

    @PostMapping("/register")
    fun register(): String{

        return ""
    }
}