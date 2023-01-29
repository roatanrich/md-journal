package com.missiondata.journal.entities

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.GenerationType
import javax.persistence.GeneratedValue
import java.util.Date
import java.util.Calendar

@Entity
class Journal(
  @Id @GeneratedValue(strategy = GenerationType.AUTO)
  var id: Long = 0,
  var createdDate: Date = Date(),
  var title: String = "",
  var comments: String = ""
)
