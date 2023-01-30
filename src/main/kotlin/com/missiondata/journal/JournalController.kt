package com.missiondata.journal

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.GetMapping
import com.missiondata.journal.entities.Journal
import com.missiondata.journal.repositories.JournalRepository
import com.missiondata.journal.repositories.EntryRepository

@RestController
@RequestMapping("/api/journals")
class JournalController(private val journalRepository: JournalRepository, private val entryRepository: EntryRepository) {

    @GetMapping
    fun findAllJournals() = journalRepository.findAll()
	
    @GetMapping("/{journalId}/entries")
    fun findAllEntries() = entryRepository.findAll()

    @GetMapping("/{journalId}")
    fun findJournalById(@PathVariable journalId: Long) = journalRepository.findById(journalId)

    @GetMapping("/{journalId}/entries/{entryId}")
    fun findEntryById(@PathVariable journalId: Long, @PathVariable entryId: Long) {
		entryRepository.findByJournalId(journalId, entryId)
	} 


//    @PostMapping
//    fun save(@RequestBody entity: Journal) = repository.save(entity)
//	
//    @DeleteMapping
//    fun save(@RequestBody entity: Journal) = repository.save(entity)
//
//	
//    @PostMapping
//    fun save(@RequestBody entity: Journal) = repository.save(entity)

}

