package com.missiondata.journal

import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.jdbc.core.JdbcTemplate
import com.missiondata.journal.entities.Journal
import org.springframework.jdbc.core.RowMapper

class JournalRepositoryImpl : JournalRepository {
    private val jdbcTemplate = JdbcTemplate(DataSourceBuilder.create().url("jdbc:hsqldb:mem:testdb").build())

    init {
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS journals (id INT PRIMARY KEY, createdDate DATE, title VARCHAR(255), comments VARCHAR(255))")
    }

    override fun findAll(): List<Journal> {
        return jdbcTemplate.query("SELECT * FROM journals", RowMapper { rs, _ ->
            Journal(rs.getLong("id"), rs.getDate("createdDate"), rs.getString("title"), rs.getString("comments"))
        })
    }

    override fun findById(id: Long): Journal? {
        return jdbcTemplate.queryForObject("SELECT * FROM journals WHERE id = ?", arrayOf(id), RowMapper { rs, _ ->
            Journal(rs.getLong("id"), rs.getDate("createdDate"), rs.getString("title"), rs.getString("comments"))
        })
    }

    override fun save(entity: Journal): Journal {
        jdbcTemplate.update("INSERT INTO journals (id, title, comments, createdDate) VALUES (?, ?, ?)", entity.id, entity.title, entity.comments, entity.createdDate)
        return entity
    }
}
