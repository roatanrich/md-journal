package com.missiondata.journal


import org.springframework.boot.test.context.SpringBootTest
import org.junit.Test
import org.junit.Assert.*
import java.net.HttpURLConnection
import java.net.URL

@SpringBootTest
class JournalApplicationTests {


	@Test
	fun getJournalListTest() {
		val url = URL("https://localhost/api/journals")
		val connection = url.openConnection() as HttpURLConnection
		connection.requestMethod = "GET"

		val responseCode = connection.responseCode
		assertEquals(200, responseCode)
	}

	@Test
	fun postJournalTest() {
		val url = URL("https://localhost/api/journals")
		val connection = url.openConnection() as HttpURLConnection
		connection.requestMethod = "POST"
		connection.doOutput = true

		val responseCode = connection.responseCode
		assertEquals(200, responseCode)
	}

	@Test
	fun getEntryListTest() {
		val url = URL("https://localhost/api/journals/{id}/entries")
		val connection = url.openConnection() as HttpURLConnection
		connection.requestMethod = "GET"

		val responseCode = connection.responseCode
		assertEquals(200, responseCode)
	}
		
	@Test
	fun getEntryItemTest() {
		val url = URL("https://localhost/api/journals/{id}/entries/{id}")
		val connection = url.openConnection() as HttpURLConnection
		connection.requestMethod = "GET"

		val responseCode = connection.responseCode
		assertEquals(200, responseCode)
	}
}



