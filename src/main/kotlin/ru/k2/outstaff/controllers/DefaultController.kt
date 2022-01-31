package ru.k2.outstaff.controllers

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import ru.k2.outstaff.persistence.CompanyRepository
import ru.k2.outstaff.persistence.WorkerRepository
import java.security.Principal

@Controller
@RequestMapping("/")
class DefaultController(private val companyRepository: CompanyRepository,
                        private val workerRepository: WorkerRepository) {

//    @GetMapping("/")
//    fun default(model: Model): String {
////        val workers = workerRepository.findAll()
////        model.addAttribute("person", workers)
//        return "index"
//    }

    @GetMapping("/home")
    fun home(model: Model, principal: Principal): String {
        val workers = workerRepository.findAll()
        model.addAttribute("username", principal.name)
        model.addAttribute("person", workers)
        return "work-sheet"
    }

    @PostMapping("/home")
    fun homeAfterLoging(model: Model): String {
        val authentication = SecurityContextHolder.getContext().authentication
//        val user = authentication.principal as User
        val user = authentication.principal as UserDetails

        val workers = workerRepository.findAll()

        model.addAttribute("person", workers)
        model.addAttribute("username", user.username)
        return "work-sheet"
    }

    @GetMapping("/auth")
    fun loginForm(): String{
        return "index"
    }

}