package ru.k2.outstaff.persistence.dto

data class WorkerDto
(
        var name: String? = null,
        var bithday: String? = null,
        var phone: String? = null,
        var mail: String? = null,
        var status: Boolean? = null,
        var type: String? = null,
        var company: String? = null,
)