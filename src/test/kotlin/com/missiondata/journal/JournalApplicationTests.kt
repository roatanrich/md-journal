package com.missiondata.journal


import org.springframework.boot.test.context.SpringBootTest
import org.junit.Test
import org.junit.Assert.*
import java.net.HttpURLConnection
import java.net.URL

@SpringBootTest
class JournalApplicationTests {


	@Test
	fun testGetCall() {
		val url = URL("https://example.com/api/get")
		val connection = url.openConnection() as HttpURLConnection
		connection.requestMethod = "GET"

		val responseCode = connection.responseCode
		assertEquals(200, responseCode)
	}

	@Test
	fun testPostCall() {
		val url = URL("https://example.com/api/post")
		val connection = url.openConnection() as HttpURLConnection
		connection.requestMethod = "POST"
		connection.doOutput = true

		val responseCode = connection.responseCode
		assertEquals(200, responseCode)
	}
}



