package com.missiondata.journal.repositories.impl

import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.jdbc.core.JdbcTemplate
import com.missiondata.journal.entities.Journal
import org.springframework.jdbc.core.RowMapper
import com.missiondata.journal.repositories.JournalRepository

class JournalRepositoryImpl : JournalRepository {
    private val jdbcTemplate = JdbcTemplate(DataSourceBuilder.create().url("jdbc:hsqldb:mem:testdb").build())

    init {
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS journals (id INT PRIMARY KEY, title VARCHAR(255))")
    }

    override fun findAll(): List<Journal> {
        return jdbcTemplate.query("SELECT * FROM journals", RowMapper { rs, _ ->
            Journal(rs.getLong("id"), rs.getString("title"))
        })
    }

    override fun findById(id: Long): Journal? {
        return jdbcTemplate.queryForObject("SELECT * FROM journals WHERE id = ?", arrayOf(id), RowMapper { rs, _ ->
            Journal(rs.getLong("id"), rs.getString("title"))
        })
    }

	override fun delete(journalId: Long): Boolean {
        jdbcTemplate.update("DELETE FROM journals WHERE id = " + journalId)
        return true
    }
	
    override fun save(entity: Journal): Journal {
        jdbcTemplate.update("INSERT INTO journals (id, title) VALUES (?, ?, ?)", entity.id, entity.title)
        return entity
    }
}
