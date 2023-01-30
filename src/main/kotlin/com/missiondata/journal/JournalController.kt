package com.missiondata.journal

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.GetMapping
import com.missiondata.journal.entities.Journal
import com.missiondata.journal.entities.Entry
import com.missiondata.journal.repositories.JournalRepository
import com.missiondata.journal.repositories.EntryRepository
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.DeleteMapping

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
    fun findEntryById(@PathVariable journalId: Long, @PathVariable entryId: Long) =	entryRepository.findByJournalId(journalId, entryId) 

    @PostMapping
    fun saveJournal(@RequestBody entity: Journal) = journalRepository.save(entity)
	
    @PostMapping("/{journalId}/entries")
    fun saveEntry(@RequestBody entity: Entry) = entryRepository.save(entity)

    @PutMapping
    fun updateJournal(@RequestBody entity: Journal) = journalRepository.save(entity)
	
    @PutMapping("/{journalId}/entries")
    fun updateEntry(@RequestBody entity: Entry) = entryRepository.save(entity)

    @DeleteMapping("/{journalId}")
    fun deleteJournal(@PathVariable journalId: Long) = journalRepository.delete(journalId)
	
    @DeleteMapping("/{journalId}/entries/{entryId}")
    fun deleteEntry(@PathVariable journalId: Long, @PathVariable entryId: Long) = entryRepository.delete(journalId, entryId)

}

