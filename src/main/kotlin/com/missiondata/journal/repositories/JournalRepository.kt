package com.missiondata.journal.repositories

import com.missiondata.journal.entities.Journal

interface JournalRepository {
    fun findAll(): List<Journal>
    fun findById(journalId: Long): Journal?
    fun save(user: Journal): Journal
	fun delete(journalId: Long): Boolean
}
