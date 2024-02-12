package io.github.chaoticneutralczech.lowestuniquengame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.GsonBuilder
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.application.call
import io.ktor.server.application.install
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.serialization.*
import io.ktor.gson.gson
import io.ktor.response.respond
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.plugins.mutableOriginConnectionPoint

// fragment initialization parameters, e.g. ARG_ITEM_NUMBER
 private const val ARG_PARAM1 = "serverIP"

class MenuPlayFragment : Fragment() {
    private var serverIP: String? = null
    private lateinit var server: NettyApplicationEngine

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            serverIP = it.getString(ARG_PARAM1)
        }
        //startServer()
       // val gson = GsonBuilder().setPrettyPrinting().create()!!
        embeddedServer(Netty, 8080) {
            install(ContentNegotiation) {
                gson {}
            }
            routing {
                get("/") {
                    call.respond(mapOf("message" to "Hello world"))
                }
            }
        }.start(wait = true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu_play, container, false)

    }

    companion object {
        @JvmStatic
        fun newInstance(serverIP: String) =
            MenuPlayFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, serverIP)
                }
            }
    }
    private fun startServer() {
        server = embeddedServer(Netty, port = 8080, module = io.ktor.server.application.Application::module)
        server.start()
    }
}