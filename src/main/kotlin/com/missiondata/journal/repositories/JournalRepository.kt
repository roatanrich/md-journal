package com.missiondata.journal.repositories

import com.missiondata.journal.entities.Journal

interface JournalRepository {
    fun findAll(): List<Journal>
    fun findById(id: Long): Journal?
    fun save(user: Journal): Journal
}
