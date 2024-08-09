package ru.k2.outstaff.dto

data class WorkerDto
(
        var id: Long? = null,
        var name: String? = null,
        var bithday: String? = null,
        var phone: String? = null,
        var mail: String? = null,
        var status: Boolean? = null,
        var type: String? = null,
        var company: String? = null,
)