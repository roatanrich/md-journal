package com.missiondata.journal.repositories.impl

import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.jdbc.core.JdbcTemplate
import com.missiondata.journal.entities.Entry
import org.springframework.jdbc.core.RowMapper
import com.missiondata.journal.repositories.EntryRepository

class EntryRepositoryImpl : EntryRepository {
    private val jdbcTemplate = JdbcTemplate(DataSourceBuilder.create().url("jdbc:hsqldb:mem:testdb").build())

    init {
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS entries (id INT PRIMARY KEY, journalId INT, comments VARCHAR(255), createdDate DATE, updatedDate DATE, deletedDate DATE)")
    }
	
    override fun findAll(): List<Entry> {
        return jdbcTemplate.query("SELECT * FROM entries", RowMapper { rs, _ ->
            Entry(rs.getLong("id"), rs.getLong("journalId"), rs.getString("comments"), rs.getDate("createdDate"), rs.getDate("updatedDate"), rs.getDate("deletedDate"))
        })
    }

	override fun findById(id: Long): Entry? {
        return jdbcTemplate.queryForObject("SELECT * FROM entries WHERE id = ?", arrayOf(id), RowMapper { rs, _ ->
            Entry(rs.getLong("id"), rs.getLong("journalId"), rs.getString("comments"), rs.getDate("createdDate"), rs.getDate("updatedDate"), rs.getDate("deletedDate"))
        })
    }
	
    override fun findByJournalId(journalId: Long, entryId: Long): List<Entry> {
		
    	val resultSet = jdbcTemplate.queryForList("SELECT * FROM entries WHERE journalId = ?", arrayOf(journalId), RowMapper { rs, _ ->
            Entry(rs.getLong("id"), rs.getLong("journalId"), rs.getString("comments"), rs.getDate("createdDate"), rs.getDate("updatedDate"), rs.getDate("deletedDate"))			
        })
		
		val result: List<Map<String, Any>> = resultSet

		return listOf()
    }

	override fun delete(journalId: Long, entryId: Long): Boolean {
        jdbcTemplate.update("DELETE FROM entries WHERE id = " + entryId)
        return true
    }
	
    override fun save(entity: Entry): Entry {
        jdbcTemplate.update("INSERT INTO entries (id, journalId, comments, createdDate, updatedDate, deleteddDate) VALUES (?, ?, ?)", entity.id, entity.journalId, entity.comments, entity.createdDate, entity.updatedDate, entity.deletedDate)
        return entity
    }
}
