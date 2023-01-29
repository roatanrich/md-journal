package com.missiondata.journal

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.GetMapping
import com.missiondata.journal.entities.Journal

@RestController
@RequestMapping("/api/journals")
class JournalController(private val repository: JournalRepository) {
    @GetMapping
    fun findAll() = repository.findAll()

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long) = repository.findById(id)

    @PostMapping
    fun save(@RequestBody entity: Journal) = repository.save(entity)
}

