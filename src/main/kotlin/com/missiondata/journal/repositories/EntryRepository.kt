package com.missiondata.journal.repositories

import com.missiondata.journal.entities.Entry

interface EntryRepository {
    fun findAll(): List<Entry>
    fun findById(id: Long): Entry?
	fun findByJournalId(journalId: Long, entryId: Long): List<Entry>
    fun save(user: Entry): Entry
}
