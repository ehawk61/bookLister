package es.meeknot

import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    install(StatusPages) {
        exception<IllegalStateException> { call, cause ->
            call.respondText("App in illegal state as ${cause.message}")
        }
    }
    routing {
        get("/healthcheck") {
            val apiVersionValue = call.request.headers["X-API-Version"]
            when (apiVersionValue) {
                "v1" -> call.respond(HttpStatusCode.OK, mapOf("apiVersion" to apiVersionValue, "status" to "UP"))
                else -> call.respond(HttpStatusCode.OK, mapOf("apiVersion" to "Undefined Version", "status" to "UP"))
            }
        }
    }
}
