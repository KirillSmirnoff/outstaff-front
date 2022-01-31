package ru.k2.outstaff.controllers

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import ru.k2.outstaff.persistence.dto.WorkerDto
import ru.k2.outstaff.service.WorkerService

@Controller
@RequestMapping("/worker")
class WorkerController(private val workerService: WorkerService) {

    @GetMapping("/register")
    fun workerRegisterForm(model: Model): String{
        model.addAttribute("worker",WorkerDto())
        return "worker-register"
    }

    @PostMapping("/register")
    fun workerRegister(workerDto: WorkerDto): String{

        workerService.saveWorker(workerDto)

        return "redirect:/"
    }
}