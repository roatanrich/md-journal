package com.missiondata.journal.entities

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.GenerationType
import javax.persistence.GeneratedValue
import java.util.Date
import java.util.Calendar

@Entity
class Entry(
  @Id @GeneratedValue(strategy = GenerationType.AUTO)
  var id: Long = 0,
  var journalId: Long = 0,
  var comments: String = "",
  var createdDate: Date = Date(),
  var updatedDate: Date = Date(),
  var deletedDate: Date = Date()
)
