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
    fun testHealthCheckWithoutAPIVersionHeader() = testApplication {
        application { module() }
        val client = createClient {
            install(ContentNegotiation) {
                json()
            }
        }
        client.get("/healthcheck").apply {
            assertEquals(HttpStatusCode.OK, status)
            runBlocking {
                val expectedRepsonse = HealthcheckResponse(apiVersion = "Undefined Version", status = "RUNNING")
                val acutalResponse = body<HealthcheckResponse>()
                assertEquals(expectedRepsonse, acutalResponse)
            }
        }
    }

    @Test
    fun testHealthCheckWithAPIVersionHeaderV1() = testApplication {
        application { module() }
        val client = createClient {
            install(ContentNegotiation) {
                json()
            }
        }
        client.get("/healthcheck") {
            headers {
                append("X-API-Version", "v1")
            }
        }.apply {
            assertEquals(HttpStatusCode.OK, status)
            runBlocking {
                val expectedRepsonse = HealthcheckResponse(apiVersion = "v1", status = "RUNNING")
                val acutalResponse = body<HealthcheckResponse>()
                assertEquals(expectedRepsonse, acutalResponse)
            }
        }
    }
}
