package es.meeknot

import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.testing.*
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.Serializable

@Serializable
data class HealthcheckResponse(val apiVersion: String, val status: String)

class ApplicationTest {

    @Test
    fun testRoot() = testApplication {
        application { module() }
        val client = createClient {
            install(ContentNegotiation) {
                json()
            }
        }
        client.get("/healthcheck").apply {
            assertEquals(HttpStatusCode.OK, status)
            runBlocking {
                val expectedRepsonse = HealthcheckResponse(apiVersion = "Undefined Version", status = "UP")
                val acutalResponse = body<HealthcheckResponse>()
                assertEquals(expectedRepsonse, acutalResponse)
            }
        }
    }
}
