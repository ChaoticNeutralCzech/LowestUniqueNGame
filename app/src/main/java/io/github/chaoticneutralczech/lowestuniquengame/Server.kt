package io.github.chaoticneutralczech.lowestuniquengame

import io.ktor.server.application.*
import io.ktor.server.routing.*
import io.ktor.server.*
import io.ktor.server.engine.*
import io.ktor.gson.*
import io.ktor.http.*
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.*
import io.ktor.server.response.*

fun Application.module() {

    routing {
        route("/hello", HttpMethod.Get) {
            handle {
                call.respondText("Hello")
            }
        }
    }
}

fun main() {
    embeddedServer(Netty, port = 8080)
}