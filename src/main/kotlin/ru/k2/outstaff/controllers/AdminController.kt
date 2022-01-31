package ru.k2.outstaff.controllers

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import ru.k2.outstaff.persistence.UserRepository
import ru.k2.outstaff.persistence.entity.UserEntity
import ru.k2.outstaff.persistence.entity.UserRoleEntity

@Controller
@RequestMapping("/admin")
class AdminController(private val userRepository: UserRepository) {

    @GetMapping("/home")
    fun admin(model: Model): String{

        val all = userRepository.findAll()

        model.addAttribute("users",all)

        return "admin"
    }

    @GetMapping("/user/register")
    fun registerForm(model: Model): String{
        model.addAttribute("user", UserRoleEntity())

        return "user-register"
    }

    @PostMapping("/register")
    fun register(): String{

        return ""
    }
}